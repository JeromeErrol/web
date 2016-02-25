package com.example.web;


import com.example.domain.Entry;
import com.example.domain.EntryRepository;
import com.example.domain.User;
import com.example.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserResourceAssembler personResourceAssembler;

    @Autowired
    EntryRepository entryRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Resource<User> select(@PathVariable Long userId) {
        User user = userRepository.findOne(userId);
        return personResourceAssembler.toResource(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/entries", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Entry> fetchEntries(@PathVariable Long userId) {
        return entryRepository.findByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{userId}/{name}")
    Resource<User> update(@PathVariable Long userId, @PathVariable String name){
        User user = userRepository.findOne(userId);
        userRepository.save(user);
        return personResourceAssembler.toResource(user);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{email}/{password}")
    @ResponseStatus(value = HttpStatus.CREATED)
    Resource<User> create(@PathVariable String email, @PathVariable String password){
        User user = new User(email, password);
        userRepository.save(user);
        return personResourceAssembler.toResource(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    void delete(@PathVariable Long userId){
        userRepository.delete(userId);
    }
}
