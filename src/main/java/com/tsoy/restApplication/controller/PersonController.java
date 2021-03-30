package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.repo.Repository;
import com.tsoy.restApplication.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    Repository repo = new Repository();
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

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


    /////////////////////////////////////////////////////////

    @GetMapping("/new/{name}")
    public Person create(@PathVariable String name){
        return personService.create(name);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Person> getById(@PathVariable long id){
        Person person = personService.getById(id);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
