package com.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Blob;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    public static final String DISCOUNT = "discount";
    public static final String TITLE = "title";

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

    @Min(0)
    @Max(1)
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

