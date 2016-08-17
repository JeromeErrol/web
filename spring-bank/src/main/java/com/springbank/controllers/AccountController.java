package com.springbank.controllers;

import com.google.common.collect.Lists;
import com.springbank.domain.Account;
import com.springbank.domain.User;
import com.springbank.exceptions.AccountOwnerException;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.UserRepository;
import com.springbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(Principal principal) {
        User owner = userService.get(principal);
        Account account = new Account();
        account.setOwner(owner);
        accountRepository.save(account);
        System.out.println("new account created for user " + owner.getUsername());
    }

    /***
     * @return A specific account. Throws and exception if the account does not belong to the authenticated user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AccountResource getById(Principal principal, @PathVariable Long id) {
        return new AccountResource(accountRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Resources<AccountResource> getAllAccountsBelongingTo(Principal principal) {
        return AccountResource.toResources(accountRepository.findByOwner(userService.get(principal)).stream());
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public Account updateBalance(Principal principal, @RequestBody Account account) throws AccountOwnerException {
        Account savedAccount = accountRepository.findOne(account.getId());
        User user = userService.get(principal);

        if (savedAccount.getOwner() == user) {
            savedAccount.setBalance(account.getBalance());
            return accountRepository.save(savedAccount);
        } else {
            throw new AccountOwnerException();
        }
    }
}
