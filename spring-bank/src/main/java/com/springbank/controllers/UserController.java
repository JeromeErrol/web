package com.springbank.controllers;


import com.springbank.domain.AccountHolder;
import com.springbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserResourceAssembler personResourceAssembler;


    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<AccountHolder> select(@PathVariable Long userId) {
        AccountHolder accountHolder = userRepository.findOne(userId);
        return personResourceAssembler.toResource(accountHolder);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}/{name}")
    Resource<AccountHolder> update(@PathVariable Long userId, @PathVariable String name) {
        AccountHolder accountHolder = userRepository.findOne(userId);
        userRepository.save(accountHolder);
        return personResourceAssembler.toResource(accountHolder);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{email}/{password}")
    @ResponseStatus(value = HttpStatus.CREATED)
    Resource<AccountHolder> create(@PathVariable String email, @PathVariable String password) {
        AccountHolder accountHolder = new AccountHolder(email, password);
        userRepository.save(accountHolder);
        return personResourceAssembler.toResource(accountHolder);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long userId) {
        userRepository.delete(userId);
    }
}
