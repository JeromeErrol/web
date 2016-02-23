package com.example.web;


import com.example.domain.Person;
import com.example.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.LongSummaryStatistics;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonResourceAssembler personResourceAssembler;

    @RequestMapping(method = RequestMethod.GET, value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<Person> select(@PathVariable Long personId) {
        Person person = personRepository.findOne(personId);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{personId}/{name}")
    Resource<Person> update(@PathVariable Long personId, @PathVariable String name){
        Person person = personRepository.findOne(personId);
        person.setName(name);
        personRepository.save(person);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{name}")
    @ResponseStatus(value = HttpStatus.CREATED)
    Resource<Person> create(@PathVariable String name){
        Person person = new Person(name);
        personRepository.save(person);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long personId){
        personRepository.delete(personId);
    }
}
