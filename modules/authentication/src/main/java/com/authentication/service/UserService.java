package com.market.authentication.service;

import com.market.authentication.domain.User;
import com.market.authentication.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserResourceAssembler personResourceAssembler;

    public Resource<User> get(Long userId) {
        User user = userRepository.findOne(userId);
        return personResourceAssembler.toResource(user);
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
