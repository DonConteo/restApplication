package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PersonRepository{
    private static final Map<Long, Person> PERSON_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger PERSON_ID = new AtomicInteger();
    private final PhoneBookRepository phoneBookRepository;

    public PersonRepository(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    public Person create(Person person) {
        final long clientId = PERSON_ID.incrementAndGet();
        person.setId(clientId);
        person.setPhoneBook(List.of (phoneBookRepository.create().getId()));
        PERSON_REPOSITORY_MAP.put(clientId, person);
        return PERSON_REPOSITORY_MAP.get(clientId);
    }

    public Person getById(long id) {
        return PERSON_REPOSITORY_MAP.get(id);
    }

    public Person getByName(String name) {
        Person person = null;
        for (Map.Entry<Long, Person> entry : PERSON_REPOSITORY_MAP.entrySet()){
            if (entry.getValue().getName().equalsIgnoreCase(name)){
                person = entry.getValue();
            }
        }
        return person;
    }

    public List<Person> getAllPerson(List<Person> list){
        for (Map.Entry<Long, Person> entry : PERSON_REPOSITORY_MAP.entrySet()){
            Person person = entry.getValue();
            list.add(person);
        }
        return list;
    }

    public boolean delete(int id) {
        return PERSON_REPOSITORY_MAP.remove(id) != null;
    }

    public void deleteAll() {
        for (Map.Entry<Long, Person> entry : PERSON_REPOSITORY_MAP.entrySet()){
            PERSON_REPOSITORY_MAP.remove(entry);
        }
    }
}
