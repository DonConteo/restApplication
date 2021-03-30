package com.tsoy.restApplication.service;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.repo.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(String name) {
        Person person = new Person(name);
        return personRepository.create(person);
    }

    public Person getById(long id) {
        return personRepository.getById(id);
    }

    public Person getByName(String name) {
        return personRepository.getByName(name);
    }
}
