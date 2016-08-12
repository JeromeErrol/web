package com.demo.web.controllers;

import com.demo.domain.Account;
import com.demo.domain.User;
import com.demo.repositories.AccountRepository;
import com.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void create(Principal principal) {
        String username = principal.getName();
        User owner = userRepository.findByUsername(username);
        Account account = new Account();
        account.setOwner(owner);
        accountRepository.save(account);
        System.out.println("new account created");
    }
}
