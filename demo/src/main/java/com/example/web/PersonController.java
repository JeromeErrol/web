package com.example.web;


import com.example.domain.Person;
import com.example.domain.PersonDoesNotExistException;
import com.example.service.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonResourceAssembler personResourceAssembler;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{name}")
    @ResponseStatus(value = HttpStatus.CREATED)
    Resource<Person> create(@PathVariable String name){
        Person person = new Person(name);
        personRepository.save(person);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<Person> select(@PathVariable Long personId) throws PersonDoesNotExistException {
        Person person = personRepository.findOne(personId);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    @ResponseStatus(HttpStatus.OK)
    void destroyPerson(@PathVariable Long personId){
        personRepository.delete(personId);
    }
}
