package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
