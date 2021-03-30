package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.PhoneBook;
import com.tsoy.restApplication.model.PhoneBookNew;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class PhoneBookRepository {
    private static final Map<PhoneBookNew, Person> PHONEBOOK_REPOSITORY_MAP = new HashMap<>();
    private static final AtomicInteger PHONEBOOK_ID = new AtomicInteger();

    public PhoneBookNew create(Person person) {
        final long phBookId = PHONEBOOK_ID.incrementAndGet();
        PhoneBookNew pbNew = new PhoneBookNew(phBookId);
        PHONEBOOK_REPOSITORY_MAP.put(pbNew, person);
        person.setPbNew(List.of(phBookId));

        return new PhoneBookNew(phBookId);
    }

    public PhoneBookNew getById(long id){
        return PHONEBOOK_REPOSITORY_MAP.entrySet().stream()
                .filter(phoneBookNewPersonEntry -> phoneBookNewPersonEntry.getKey().getId() == id)
                .findFirst()
                .get()
                .getKey();
    }
}
