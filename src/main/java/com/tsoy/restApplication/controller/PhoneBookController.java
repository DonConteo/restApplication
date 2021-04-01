package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.Record;
import com.tsoy.restApplication.service.PersonService;
import com.tsoy.restApplication.service.PhoneBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("phone")
public class PhoneBookController {

    PhoneBookService phoneBookService;
    PersonService personService;

    public PhoneBookController(PhoneBookService phoneBookService, PersonService personService) {
        this.phoneBookService = phoneBookService;
        this.personService = personService;
    }

    @GetMapping("add/{id}/{phone}/{name}")
    public ResponseEntity<Person> addRecord(@PathVariable long id,
                                            @PathVariable String phone,
                                            @PathVariable String name){
        phoneBookService.addRecord(id, phone, name);
        return new ResponseEntity<>(personService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("updatename/{personid}/{recordid}/{newname}")
    public ResponseEntity<Person> updateRecordName(@PathVariable long personid,
                                               @PathVariable long recordid,
                                               @PathVariable String newname){
        Person person = personService.getUser(personid);
        Record record = person.getPhoneBook().getRecords().get(recordid);
        if (record != null) {
            phoneBookService.updateRecordName(record, newname);
        }
        return record != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("updatenumber/{personid}/{recordid}/{newnumber}")
    public ResponseEntity<Person> updateRecordNumber(@PathVariable long personid,
                                               @PathVariable long recordid,
                                               @PathVariable String newnumber){
        Person person = personService.getUser(personid);
        Record record = person.getPhoneBook().getRecords().get(recordid);
        if (record != null) {
            phoneBookService.updateRecordNumber(record, newnumber);
        }
        return record != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("delete/{personid}/{recordid}")
    public ResponseEntity<Person> deleteRecord(@PathVariable long personid,
                                               @PathVariable long recordid){
        Person person = personService.getUser(personid);
        phoneBookService.deleteRecord(person, recordid);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
