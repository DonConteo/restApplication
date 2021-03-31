package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.service.PersonService;
import com.tsoy.restApplication.service.PhoneBookService;
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

    @GetMapping("add/{person}/{phonebook}/{name}/{phone}")
    public void addRecord(@PathVariable long person,
                          @PathVariable String name,
                          @PathVariable String phone){
        phoneBookService.addRecord(person, name, phone);
    }


}