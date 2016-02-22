package com.example.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Person {
    @Getter
    private int id;
    @Getter
    private List<Person> friends;

    public Person(int id){
        this.id = id;
        friends = new ArrayList<>();
    }
}
