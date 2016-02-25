package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private String role;
}
