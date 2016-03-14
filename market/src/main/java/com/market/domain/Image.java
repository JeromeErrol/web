package com.market.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private byte[] image;
}
