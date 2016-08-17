package com.springbank.controllers;

import com.springbank.domain.Account;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

import java.security.Principal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class AccountResource extends ResourceSupport {

    private final Account account;

    public AccountResource(Account account) {
        this.account = account;
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return account.getOwner().getUsername();
            }

            ;
        };
        this.add(linkTo(methodOn(AccountController.class, getId()).getById(principal, account.getId())).withSelfRel());
        this.add(linkTo(AccountController.class, getId()).withRel("accounts"));

    }

    public Account getAccount() {
        return account;
    }

    public static Resources<AccountResource> toResources(Stream<Account> stream) {
        return new Resources<AccountResource>(
                stream
                        .map(AccountResource::new)
                        .collect(Collectors.toList()));
    }
}
