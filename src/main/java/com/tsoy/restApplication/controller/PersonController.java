package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonController {

    public List<Map<String, String>> phones1 = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>() {{ put("number", "890"); put("contact", "kotik"); }});
        add(new HashMap<String, String>() {{ put("number", "8901"); put("contact", "doggo"); }});
        add(new HashMap<String, String>() {{ put("number", "8902"); put("contact", "parrot"); }});
    }};

    public List<Map<String, String>> phones2 = new ArrayList<Map<String, String>>(){{
        add(new HashMap<String, String>() {{ put("number", "8901"); put("contact", "koti"); }});
        add(new HashMap<String, String>() {{ put("number", "89011"); put("contact", "dogg"); }});
        add(new HashMap<String, String>() {{ put("number", "89021"); put("contact", "parro"); }});
    }};

    Person person1 = new Person(1, "john", phones1);
    Person person2 = new Person(2, "kuk", phones2);

    public List<Person> persons = new ArrayList<Person>(){{
        add(person1);
        add(person2);
    }};

    @GetMapping
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
}
