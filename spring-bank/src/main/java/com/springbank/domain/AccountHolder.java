package com.springbank.domain;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table
public class AccountHolder {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String password;

    @JoinColumn(name = "user_id")
    @OneToMany
    private Set<UserRole> userRoles;


    public AccountHolder(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AccountHolder() {

    }
}
