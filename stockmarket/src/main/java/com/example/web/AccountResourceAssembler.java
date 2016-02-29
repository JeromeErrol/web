package com.example.web;

import com.example.domain.Account;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class AccountResourceAssembler implements ResourceAssembler<Account, Resource<Account>> {

    @Override
    public Resource<Account> toResource(Account account) {
        Resource<Account> resource = new Resource<>(account);
        resource.add(linkTo(AccountController.class).slash(account.getId()).withSelfRel());
        return resource;
    }
}
