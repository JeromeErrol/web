package com.springbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AccountTransaction extends AbstractEntity {

    @NotNull
    @Column
    private Long amount;

    @NotNull
    @ManyToOne
    private Account source;

    @NotNull
    @ManyToOne
    private Account target;

    public void process() {
        source.addToBalance(-amount);
        target.addToBalance(amount);
    }

    public AccountTransaction(Long amount, Account source, Account target) {
        this.amount = amount;
        this.source = source;
        this.target = target;
    }
}
