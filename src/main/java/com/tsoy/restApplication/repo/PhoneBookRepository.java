package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.PhoneBook;
import com.tsoy.restApplication.service.PersonService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class PhoneBookRepository {
    private static final List<PhoneBook> PHONEBOOK_REPOSITORY_MAP = new ArrayList<>();

    public PhoneBook create() {
        PhoneBook pbNew = new PhoneBook(new HashMap<>());
        PHONEBOOK_REPOSITORY_MAP.add(pbNew);
        return pbNew;
    }
}
