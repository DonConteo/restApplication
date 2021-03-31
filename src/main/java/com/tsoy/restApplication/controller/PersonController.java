package com.tsoy.restApplication.controller;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/new/{name}")
    public Person createPerson(@PathVariable String name){
        return personService.create(name);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Person> getById(@PathVariable long id){
        Person person = personService.getById(id);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getbyname/{name}")
    public ResponseEntity<Person> getByName(@PathVariable String name){
        Person person = personService.getByName(name);
        return person != null
                ? new ResponseEntity<>(person, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("getall")
    public List<Person> getAllPerson(){
        return personService.getAllPerson();

    }

    @GetMapping("deletePerson/{id}")
    public ResponseEntity deletePerson(@PathVariable long id){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("deleteall")
    public ResponseEntity deleteAll(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
