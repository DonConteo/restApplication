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

    @GetMapping
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

    @RequestMapping("/deletePerson/personId")
    public List<Person> deletePerson(
            @RequestParam(value = "id") long id){
        repo.deletePerson(id);
        return repo.persons();
    }

    @RequestMapping("/createPerson")
    public Person createPerson(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "name") String name){
        repo.createPerson(id, name);
        return repo.personById(id);
    }
}
