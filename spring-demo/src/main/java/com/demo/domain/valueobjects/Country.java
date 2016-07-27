package com.demo.domain.valueobjects;

import javax.persistence.*;

@Entity
public class Country {

    @Column
    private String title;

    @ManyToOne
    private Continent continent;

    @Id
    @GeneratedValue
    @Column
    private long id;

    public Country() {

    }

    public Country(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
