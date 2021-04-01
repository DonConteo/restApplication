package com.tsoy.restApplication.service;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.Record;
import com.tsoy.restApplication.repo.PhoneBookRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PhoneBookService {
    private final PhoneBookRepository phoneBookRepository;
    private final PersonService personService;
    private static final AtomicInteger RECORD_ID = new AtomicInteger();

    public PhoneBookService(PhoneBookRepository phoneBookRepository, PersonService personService) {
        this.phoneBookRepository = phoneBookRepository;
        this.personService = personService;
    }

    public void addRecord(long id, String name, String phone) {
        Person person = personService.getById(id);
        final long recordId = RECORD_ID.incrementAndGet();
        Record record = new Record(name, phone);
        person.getPhoneBook().getRecords().put(recordId, record);
    }

    public void deleteRecord(Person person, long id){
        person.getPhoneBook().getRecords().entrySet().removeIf(entry -> id == entry.getKey());
    }

    public void updateRecordName(Record record, String name){
        record.setName(name);
    }

    public void updateRecordNumber(Record record, String number){
        record.setNumber(number);
    }
}