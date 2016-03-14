package com.market.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String email;

    @Getter
    @Setter
    @Column
    private String password;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
