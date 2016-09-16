package com.springbank.services;

import com.springbank.domain.AccountHolder;
import com.springbank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AccountHolder get(Principal principal){
        return userRepository.findByUsername(principal.getName());
    }
}
