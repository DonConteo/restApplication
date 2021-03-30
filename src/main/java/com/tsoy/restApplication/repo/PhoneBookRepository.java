package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.PhoneBook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class PhoneBookRepository {
    private static final List<PhoneBook> PHONEBOOK_REPOSITORY_MAP = new ArrayList<>();
    private static final AtomicInteger PHONEBOOK_ID = new AtomicInteger();

    public PhoneBook create() {
        final long phBookId = PHONEBOOK_ID.incrementAndGet();
        PhoneBook pbNew = new PhoneBook(phBookId);
        PHONEBOOK_REPOSITORY_MAP.add(pbNew);
        return new PhoneBook(phBookId);
    }

    public PhoneBook getById(long id) {
        return PHONEBOOK_REPOSITORY_MAP.stream()
                .filter(phoneBook -> phoneBook.getId() == id)
                .findFirst()
                .get();
    }
}
