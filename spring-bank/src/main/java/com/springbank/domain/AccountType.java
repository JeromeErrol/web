package com.springbank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class AccountType extends AbstractEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private AccountTypeName name;

    @Column
    private Long interest;

    public AccountTypeName getName() {
        return name;
    }

    public void setName(AccountTypeName name) {
        this.name = name;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public AccountType() {
    }

    public AccountType(AccountTypeName name, Long interest) {
        this.name = name;
        this.interest = interest;
    }
}
