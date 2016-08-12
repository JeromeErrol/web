package com.demo.services;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Secured("USER2")
    public String secure(){
        return "hello security";
    }

}
