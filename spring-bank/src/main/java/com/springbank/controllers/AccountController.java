package com.springbank.controllers;

import com.springbank.domain.Account;
import com.springbank.domain.AccountHolder;
import com.springbank.exceptions.AccountOwnerException;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.AccountTransactionRepository;
import com.springbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(Principal principal, @RequestBody Account account) {
        AccountHolder owner = userService.get(principal);
        Account newAccount = new Account(owner);
        newAccount.setOwner(owner);
        accountRepository.save(newAccount);
        System.out.println("new account created for user " + owner.getUsername());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AccountResource getById(Principal principal, @PathVariable Long id) {
        return new AccountResource(accountRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Resources<AccountResource> getAllAccountsBelongingTo(Principal principal) {
        return AccountResource.toResources(accountRepository.findByOwner(userService.get(principal)).stream());
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Account patch(Principal principal, @RequestBody Account account) throws AccountOwnerException {
        Account savedAccount = accountRepository.findOne(account.getId());
        if (savedAccount != null) {
            AccountHolder accountHolder = userService.get(principal);
            if (savedAccount.getOwner() == accountHolder) {
                savedAccount.setBalance(account.getBalance());
                return accountRepository.save(savedAccount);
            }
            throw new AccountOwnerException();
        }
        throw new ResourceNotFoundException();
    }
}
