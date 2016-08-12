package com.demo.domain

import javax.persistence.*

@Entity
public class City {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    @ManyToOne
    private Country country;


    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    Country getCountry() {
        return country
    }

    void setCountry(Country country) {
        this.country = country
    }
}
