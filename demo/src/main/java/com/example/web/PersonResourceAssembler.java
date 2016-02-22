package com.example.web;

import com.example.domain.Person;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class PersonResourceAssembler implements ResourceAssembler<Person, Resource<Person>>{
    @Override
    public Resource<Person> toResource(Person person) {
        Resource<Person> resource = new Resource<Person>(person);
        resource.add(linkTo(PersonController.class).slash(person.getId()).slash("friends").withRel("friends"));
        resource.add(linkTo(PersonController.class).slash(person.getId()).withSelfRel());
        return resource;
    }
}
