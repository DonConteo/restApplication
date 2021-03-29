package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.Models.Person;
import com.tsoy.restApplication.Models.PhoneBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    PhoneBook phoneBook1 = new PhoneBook(1, "123", "doggo1");
    PhoneBook phoneBook2 = new PhoneBook(2, "1234", "doggo2");
    PhoneBook phoneBook3 = new PhoneBook(3, "12345", "doggo3");
    PhoneBook phoneBook4 = new PhoneBook(4, "123456", "doggo4");
    PhoneBook phoneBook5 = new PhoneBook(5, "1234567", "doggo5");
    PhoneBook phoneBook6 = new PhoneBook(6, "12345678", "doggo6");

    Person person1 = new Person(1, "Vasya", new ArrayList<>(){{
        add(phoneBook1);
        add(phoneBook2);
        add(phoneBook3);
    }});
    Person person2 = new Person(2, "Petya", new ArrayList<>(){{
        add(phoneBook4);
        add(phoneBook5);
        add(phoneBook6);
    }});

    public List<Person> persons = new ArrayList<>(){{
        add(person1);
        add(person2);
    }};

    public List<PhoneBook> phoneBooks = new ArrayList<>(){{
        add(phoneBook1);
        add(phoneBook2);
        add(phoneBook3);
        add(phoneBook4);
        add(phoneBook5);
        add(phoneBook6);
    }};

    @GetMapping("/persons")
    public List<Person> persons(){
        return persons;
    }

    @GetMapping("/id/{id}")
    public Person getById(@PathVariable(value = "id") long id){
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/name/{name}")
    public Person getByName(@PathVariable(value = "name") String name){
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/contactId/{contactId}")
    public PhoneBook getByContactId(@PathVariable(value = "contactId") long contactId){
        return phoneBooks.stream()
                .filter(phonebook -> phonebook.getContactId() == contactId)
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/number/{number}")
    public PhoneBook getByNumber(@PathVariable(value = "number") String number){
        return phoneBooks.stream()
                .filter(phonebook -> phonebook.getNumber().equals(number))
                .findFirst()
                .orElseThrow();
    }
}