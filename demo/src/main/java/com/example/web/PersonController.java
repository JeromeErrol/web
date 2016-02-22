package com.example.web;


import com.example.domain.Person;
import com.example.domain.PersonDoesNotExistException;
import com.example.domain.PersonRepository;
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

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    Resource<Person> createPerson(){
        Person person = personRepository.create();
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<Person> showPerson(@PathVariable Integer personId) throws PersonDoesNotExistException {
        Person person = personRepository.get(personId);
        return personResourceAssembler.toResource(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{personId}/friends/{friendId}")
    @ResponseStatus(value = HttpStatus.OK)
    void addFriend(@PathVariable Integer personId, @PathVariable Integer friendId) throws PersonDoesNotExistException {
        Person person = personRepository.get(personId);
        Person friend = personRepository.get(friendId);
        person.getFriends().add(friend);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{personId}")
    @ResponseStatus(HttpStatus.OK)
    void destroyPerson(@PathVariable Integer personId){
        personRepository.remove(personId);
    }
}
