package com.example.domain;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    int idIndex = 0;
    List<Person> persons;

    @PostConstruct
    void postConstruct() {
        persons = new ArrayList<>();
    }

    public Person create() {
        idIndex++;
        Person person = new Person(idIndex);
        persons.add(person);
        return person;
    }

    public Person get(int id) throws PersonDoesNotExistException {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new PersonDoesNotExistException(id);
    }

    public void remove(int personId) {
        Integer index = null;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == personId) {
                index = i;
                break;
            }
        }
        if (index != null) {
            persons.remove(index);
        }
    }
}
