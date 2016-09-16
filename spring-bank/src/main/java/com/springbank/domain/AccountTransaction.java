package com.springbank.domain;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class AccountTransaction extends AbstractEntity {

    @Min(value = 1)
    @NotNull
    @Column
    private Long amount;

    @Column
    private boolean processed;

    @NotNull
    @ManyToOne
    private Account source;

    @NotNull
    @ManyToOne
    private Account target;

    public void process() {
        if (!processed) {
            source.addToBalance(-amount);
            target.addToBalance(amount);
            processed = true;
        }
    }

    public AccountTransaction(Long amount, Account source, Account target) {
        this.amount = amount;
        this.source = source;
        this.target = target;
    }

    public AccountTransaction() {
    }


    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public Account getTarget() {
        return target;
    }

    public void setTarget(Account target) {
        this.target = target;
    }
}
