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

    public Person getPerson(long id) {
        return personRepository.getUser(id);
    }

    public Person getPerson(String name) {
        return personRepository.getUser(name);
    }

    public List<Person> getAllPerson(){
        List<Person> list = new ArrayList<>();
        return personRepository.getAllPerson(list);
    }

    public void updatePerson(long id, String name){
        personRepository.updatePerson(id, name);
    }

    public void deletePerson(long id){
        personRepository.delete(id);
    }
}
