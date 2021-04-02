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
        final long recordId = RECORD_ID.incrementAndGet();
        personService.getPerson(id).getPhoneBook().getRecords().put(recordId, new Record(name, phone));
    }

    public Record getRecord(long personid, long  recordid) {
        return personService.getPerson(personid).getPhoneBook().getRecords().get(recordid);
    }

    public void updateRecordName(Record record, String name){
        record.setName(name);
    }

    public void updateRecordNumber(Record record, String number){
        record.setNumber(number);
    }

    public void deleteRecord(Person person, long id){
        person.getPhoneBook().getRecords().entrySet().removeIf(entry -> id == entry.getKey());
    }

    public boolean cleanAllRecord(long i) {
        personService.getPerson(i).getPhoneBook().getRecords().clear();
        return personService.getPerson(i).getPhoneBook().getRecords().isEmpty();
    }
}