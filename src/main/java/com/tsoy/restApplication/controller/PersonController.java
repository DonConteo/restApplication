package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    private static PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("new/{name}")
    public Person createPerson(@PathVariable String name){
        return personService.create(name);
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<Person> getById(@PathVariable long id){
        Person person = personService.getPerson(id);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getbyname/{name}")
    public ResponseEntity<Person> getByName(@PathVariable String name){
        Person person = personService.getPerson(name);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getall")
    public ResponseEntity<List<Person>> getAllPerson() {
        List<Person> lp = personService.getAllPerson();
        return lp.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(lp, HttpStatus.OK);
    }

    @GetMapping("update/{id}/{newname}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id,
                                               @PathVariable String newname){
        if (personService.getPerson(id) != null) {
            personService.updatePerson(id, newname);
        }
        return personService.getPerson(id) != null
                ? new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity deletePerson(@PathVariable long id){
        personService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
