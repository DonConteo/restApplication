package com.tsoy.restApplication.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @Autowired
    PhoneBookService phoneBookService;

    @BeforeEach
    public void setup() {
        personService.create("Vasya");
        personService.create("Petya");
        personService.create("Marina");
        phoneBookService.addRecord(personService.getPerson("Vasya").getId(), "aaa","222");
        phoneBookService.addRecord(personService.getPerson("Vasya").getId(), "sss","222");
        phoneBookService.addRecord(personService.getPerson("Petya").getId(), "www","222");
        phoneBookService.addRecord(personService.getPerson("Petya").getId(), "qqq","222");
        phoneBookService.addRecord(personService.getPerson("Marina").getId(), "ttt","222");
        phoneBookService.addRecord(personService.getPerson("Marina").getId(), "uuu","222");
    }

    @AfterEach
    void after(){
        personService.getAllPerson().clear();
    }

    @Test
    @DisplayName("get person by name")
    void getUserByNameTest() {
        assertEquals(personService.getPerson("Vasya").getId(), 1);
    }

    @Test
    @DisplayName("get person by id")
    void getUserByIdTest() {
        assertEquals(personService.getPerson(2).getName(), "Petya");
    }

    @Test
    @DisplayName("update person")
    void updateUserTest() {
        personService.updatePerson(1, "Napoleon");
        String newName = "Napoleon";
        assertEquals(personService.getPerson(1).getName(), newName);
    }

    @Test
    @DisplayName("delete person")
    void deletePersonTest() {
        personService.deletePerson(3);
        assertEquals(personService.getPerson(3), null);
    }
}