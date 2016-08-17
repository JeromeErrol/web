package com.springbank.controllers;

import com.springbank.domain.Account;
import com.springbank.domain.AccountTransaction;
import com.springbank.domain.BaseAccountTransaction;
import com.springbank.domain.User;
import com.springbank.exceptions.AccountOwnerException;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.AccountTransactionRepository;
import com.springbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/transactions")
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTransaction(Principal principal, @RequestBody BaseAccountTransaction baseAccountTransaction) {
        Account source = accountRepository.findOne(baseAccountTransaction.getSourceAccountId());
        Account target = accountRepository.findOne(baseAccountTransaction.getTargetAccountId());

        if (source != null) {
            if (target != null) {
                User user = userService.get(principal);
                if (source.getOwner() == user) {
                    AccountTransaction accountTransaction = new AccountTransaction(baseAccountTransaction.getAmount(), source, target);
                    accountTransactionRepository.save(accountTransaction);
                } else {
                    throw new AccountOwnerException();
                }
            } else {
                throw new ResourceNotFoundException("target account does not exist");
            }
        } else {
            throw new ResourceNotFoundException("source account does not exist");
        }
    }
}
