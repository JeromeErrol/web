package com.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @Column
    private String title;

    @Column
    @Getter
    @Setter
    private Double price;

    @Column
    @Getter
    @Setter
    private Double discount;

    @ManyToOne
    @Getter
    @Setter
    private Category category;

    @ManyToOne
    @Getter
    @Setter
    private Image image;
}

