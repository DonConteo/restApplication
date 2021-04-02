package com.tsoy.restApplication.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PhoneBookServiceTest {

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
    @DisplayName("add record")
    void addRecordTest() {
        phoneBookService.addRecord(1, "doggo", "666");
        assertEquals(phoneBookService.getRecord(1, 7).getName(), "doggo");
        assertEquals(phoneBookService.getRecord(1, 7).getNumber(), "666");
    }

    @Test
    @DisplayName("get record")
    void getRecordByIdTest() {
        assertEquals(phoneBookService.getRecord(1, 2).getName(), "sss");
        assertEquals(phoneBookService.getRecord(1, 2).getNumber(), "222");
    }

    @Test
    @DisplayName("update record name")
    void updateRecordNameTest() {
        phoneBookService.updateRecordName(phoneBookService.getRecord(1, 1), "doggo");
        assertEquals(phoneBookService.getRecord(1, 1).getName(), "doggo");
    }

    @Test
    @DisplayName("update record number")
    void updateRecordNumberTest() {
        phoneBookService.updateRecordNumber(phoneBookService.getRecord(1, 1), "666");
        assertEquals(phoneBookService.getRecord(1, 1).getNumber(), "666");
    }

    @Test
    @DisplayName("delete record")
    void deleteRecordTest() {
        phoneBookService.deleteRecord(personService.getPerson(3), 6);
        assertEquals(phoneBookService.getRecord(3, 6), null);
    }

    @Test
    @DisplayName("delete all records")
    void cleanAllRecords(){
        assertTrue(phoneBookService.cleanAllRecord(2));
    }
}
