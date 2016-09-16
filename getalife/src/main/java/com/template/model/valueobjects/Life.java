package com.template.model.valueobjects;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Life {

    /***
     * These are the dependencies which the system needs to autowire
     */
    private List<Dependency> dependencies;
}
