package com.demo.domain.valueobjects

import javax.persistence.*

@Entity
public class City {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String title;


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
}
