package com.tsoy.restApplication.service;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.PhoneBook;
import com.tsoy.restApplication.repo.PersonRepository;
import com.tsoy.restApplication.repo.PhoneBookRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneBookService {
    private final PhoneBookRepository phoneBookRepository;
    private final PersonService personService;

    public PhoneBookService(PhoneBookRepository phoneBookRepository, PersonService personService) {
        this.phoneBookRepository = phoneBookRepository;
        this.personService = personService;
    }

    public void addRecord(long id, String phone, String name) {
        Person person = personService.getById(id);
        person.getPhoneBook().getRecords().put(phone, name);
    }
}
