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

    public Person create(Person person) {
        final long clientId = PERSON_ID.incrementAndGet();
        person.setId(clientId);
        PERSON_REPOSITORY_MAP.put(clientId, person);
        return PERSON_REPOSITORY_MAP.get(clientId);
    }

    public Person getById(long id) {
        return PERSON_REPOSITORY_MAP.get(id);
    }

    public List<Person> readAll() {
        return new ArrayList<>(PERSON_REPOSITORY_MAP.values());
    }

    public Person read(int id) {
        return PERSON_REPOSITORY_MAP.get(id);
    }

    public boolean update(Person person, long id) {
        if (PERSON_REPOSITORY_MAP.containsKey(id)) {
            person.setId(id);
            PERSON_REPOSITORY_MAP.put(id, person);
            return true;
        }

        return false;
    }

    public boolean delete(int id) {
        return PERSON_REPOSITORY_MAP.remove(id) != null;
    }


}
