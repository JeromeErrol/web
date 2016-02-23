package com.example.service;

import com.example.domain.Person;
import com.example.domain.PersonDoesNotExistException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


}
