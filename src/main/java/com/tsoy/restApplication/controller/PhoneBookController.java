package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.PhoneBook;
import com.tsoy.restApplication.model.PhoneBookNew;
import com.tsoy.restApplication.repo.PhoneBookRepository;
import com.tsoy.restApplication.repo.Repository;
import com.tsoy.restApplication.service.PersonService;
import com.tsoy.restApplication.service.PhoneBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneBookController {

    Repository repo = new Repository();
    //////////////////////////////////////////////
    PhoneBookService phoneBookService;
    PersonService personService;

    public PhoneBookController(PhoneBookService phoneBookService, PersonService personService) {
        this.phoneBookService = phoneBookService;
        this.personService = personService;
    }

    @GetMapping("new/{id}")
    public PhoneBookNew create(@PathVariable long id){
        return phoneBookService.create(id);
    }

    @GetMapping("add/{person}/{phonebook}/{name}/{phone}")
    public void addRecord(@PathVariable long person,
                          @PathVariable String name,
                          @PathVariable String phone){
        phoneBookService.addRecord(person, name, phone);
    }

    //////////////////////////////////////////////


    @GetMapping("/allContacts")
    public List<PhoneBook> phoneBooks(){
        return repo.phoneBooks();
    }

    @RequestMapping("/contactId")
    public PhoneBook byContactId(@RequestParam(value = "id") long contactId){
        return repo.phoneBookById(contactId);
    }

    @RequestMapping("/contactNumber")
    public PhoneBook byNumber(@RequestParam(value = "number") String number){
        return repo.phoneByNumber(number);
    }

    @RequestMapping("/contactName")
    public PhoneBook byName(@RequestParam(value = "name") String name){
        return repo.phoneByName(name);
    }


}