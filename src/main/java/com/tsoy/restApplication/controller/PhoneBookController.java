package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
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
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @GetMapping("update/{id}/")
}