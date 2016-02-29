package com.example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue
    @Getter
    @Column
    private Long id;

    @Getter
    @Setter
    @Column
    private Long entryId;

    @Getter
    @Setter
    @Column
    private String word;

    public Tag(Long entryId, String word){
        this.entryId = entryId;
        this.word = word;
    }
}
