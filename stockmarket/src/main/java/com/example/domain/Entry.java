package com.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Entry {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private String text;

    @Getter
    @Setter
    @Column
    private Long userId;
}
