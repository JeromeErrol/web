package com.springbank.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;

    @Column
    private String role;

    public UserRole(AccountHolder accountHolder, String role) {
        this.accountHolder = accountHolder;
        this.role = role;
    }

    public UserRole(){

    }
}
