package com.springbank.controllers;

import com.springbank.domain.AccountHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class UserResourceAssembler implements ResourceAssembler<AccountHolder, Resource<AccountHolder>> {
    @Override
    public Resource<AccountHolder> toResource(AccountHolder accountHolder) {
        Resource<AccountHolder> resource = new Resource<AccountHolder>(accountHolder);
        resource.add(linkTo(UserController.class).slash(accountHolder.getId()).withSelfRel());
        resource.add(linkTo(UserController.class).slash(accountHolder.getId()).slash("entries").withRel("entries"));
        return resource;
    }
}
