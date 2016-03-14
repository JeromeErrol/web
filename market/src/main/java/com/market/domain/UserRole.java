package com.market.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String role;
}
