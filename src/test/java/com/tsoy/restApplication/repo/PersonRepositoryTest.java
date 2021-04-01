package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.controller.PersonController;
import com.tsoy.restApplication.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonService personService;

    @Autowired
    PhoneBookService phoneBookService;

    @BeforeEach
    public void setup() {
        personService.create("Vasya");
        personService.create("Petya");
        personService.create("Marina");
        phoneBookService.addRecord(personService.getUser("Vasya").getId(), "aaa","222");
        phoneBookService.addRecord(personService.getUser("Vasya").getId(), "sss","222");
        phoneBookService.addRecord(personService.getUser("Petya").getId(), "www","222");
        phoneBookService.addRecord(personService.getUser("Petya").getId(), "qqq","222");
        phoneBookService.addRecord(personService.getUser("Marina").getId(), "ttt","222");
        phoneBookService.addRecord(personService.getUser("Marina").getId(), "uuu","222");
    }

    @AfterEach
    void after(){
        personService.getAllPerson().clear();
    }

    @Test
    @DisplayName("get user by name")
    void getUserByNameTest() {
        assertEquals(personService.getUser("Vasya").getId(), 4L);
    }

    @Test
    @DisplayName("clean all records")
    void cleanAllRecords(){
        assertTrue(phoneBookService.cleanAllRecord(1L));
    }

    @Test
    @DisplayName("get user by id")
    void getUserByIdTest() {
        assertEquals(personService.getUser(2L).getName(), "Petya");
    }

}