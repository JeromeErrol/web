package com.demo.domain.valueobjects;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Stock {

    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    public static final String DISCOUNT = "discount";
    public static final String TITLE = "title";

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @Column
    private Double price;

    @Min(0)
    @Max(1)
    @Column
    private Double discount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Image image;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

