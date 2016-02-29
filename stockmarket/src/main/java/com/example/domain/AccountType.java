package com.example.domain;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountType {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Double interest;

    @Column
    private Double cost;
}
