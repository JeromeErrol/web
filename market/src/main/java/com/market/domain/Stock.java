package com.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Getter
    @Setter
    @Column
    private String title;

    @NotNull
    @Column
    @Getter
    @Setter
    private Double price;

    @Size(min = 0, max = 1)
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

