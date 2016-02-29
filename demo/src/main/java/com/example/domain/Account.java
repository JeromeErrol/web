package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Enumerated(EnumType.STRING)
    public AccountType accountType;

    @Setter
    @Getter
    @Column
    private Double amount;

    @Column
    private Double interest;
}
