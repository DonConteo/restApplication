package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.Models.PhoneBook;
import com.tsoy.restApplication.repo.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneBookController {

    Repository repo = new Repository();

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