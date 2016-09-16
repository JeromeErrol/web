package de.admir.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Account extends AbstractModel {

    @Column
    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
