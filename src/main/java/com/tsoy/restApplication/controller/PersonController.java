package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.Models.Person;
import com.tsoy.restApplication.repo.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    Repository repo = new Repository();

    @GetMapping("/allPersons")
    public List<Person> persons(){
        return repo.persons();
    }

    @RequestMapping("/personName")
    public Person byName(@RequestParam(value = "name") String name){
        return repo.personByName(name);
    }

    @RequestMapping("/personId")
    public Person byId(@RequestParam(value = "id") long id){
        return repo.personById(id);
    }

    @PostMapping("/deletePerson")
    public void deletePerson(
            @RequestParam(value = "id") long id){
        repo.deletePerson(byId(id));
    }

    @PostMapping("/updatePerson")
    public Person createPerson(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "name") String name){
        Person person = repo.personById(id);
        if (person == null){
            return repo.createPerson(new Person(id, name, new ArrayList<>()));
        }
        else {
            person.setName(name);
            return person;
        }
    }
}