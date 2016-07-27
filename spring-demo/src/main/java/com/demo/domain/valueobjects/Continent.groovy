package com.demo.domain.valueobjects

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Continent {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String title;

    public Continent() {

    }

    long getId() {
        return id
    }

    void setId(long id) {
        this.id = id
    }

    String getTitle() {
        return title
    }

    void setTitle(String title) {
        this.title = title
    }
}
