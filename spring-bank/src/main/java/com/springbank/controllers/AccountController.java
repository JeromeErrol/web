package com.springbank.controllers;

import com.springbank.domain.Account;
import com.springbank.domain.User;
import com.springbank.repositories.AccountRepository;
import com.springbank.repositories.UserRepository;
import com.springbank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.stream.Collectors;

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
    public void create(Principal principal) {
        User owner = userService.get(principal);
        Account account = new Account();
        account.setOwner(owner);
        accountRepository.save(account);
        System.out.println("new account created");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public AccountResource getById(Principal principal, @PathVariable Long id) {
        return new AccountResource(accountRepository.findOne(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Resources<AccountResource> get(Principal principal) {
        return new Resources<AccountResource>(
                accountRepository.findByOwner(userService.get(principal))
                        .stream()
                        .map(AccountResource::new)
                        .collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Account updateBalance(Principal principal, @RequestBody Account account) {
        Account savedAccount = accountRepository.findOne(account.getId());
        savedAccount.setBalance(account.getBalance());
        return accountRepository.save(savedAccount);
    }
}
