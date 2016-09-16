package com.springbank.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account extends AbstractEntity {

    @Column
    private double balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AccountHolder owner;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountHolder getOwner() {
        return owner;
    }

    public void setOwner(AccountHolder owner) {
        this.owner = owner;
    }

    public Account() {
    }

    public Account(AccountHolder owner) {
        this.owner = owner;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }
}
