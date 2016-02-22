package com.example.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PersonDoesNotExistException extends Exception {

    public int personId;

    public PersonDoesNotExistException(int personId){
        super("The person could not be found");
        this.personId = personId;
    }
}
