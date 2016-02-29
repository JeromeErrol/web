package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "account_type_id")
    public AccountType accountType;

    @Setter
    @Getter
    @Column
    private Double amount;


    public Account(User owner, AccountType accountType, Double amount) {
        setOwner(owner);
        this.accountType = accountType;
        this.amount = amount;
    }
}
