package com.example.web;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private AccountResourceAssembler accountResourceAssembler;

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/{accountTypeName}/{amount}", method = RequestMethod.POST)
    public Resource<Account> create(@PathVariable String accountTypeName, @PathVariable Double amount) {
        AccountType accountType = accountTypeRepository.findByName(accountTypeName);
        Account account = new Account(getCurrentUser(), accountType, amount);
        account = accountRepository.save(account);
        return accountResourceAssembler.toResource(account);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Resource<Account>> select() {
        List<Account> accounts = accountRepository.findByOwner(getCurrentUser());
        List<Resource<Account>> accountResources = new ArrayList<>();
        for (Account account : accounts) {
            accountResources.add(accountResourceAssembler.toResource(account));
        }
        return accountResources;
    }

    private com.example.domain.User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername(); //get logged in username
        return userRepository.findByEmail(username);
    }
}
