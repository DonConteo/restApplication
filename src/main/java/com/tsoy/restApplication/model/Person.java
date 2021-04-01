package com.tsoy.restApplication.model;

import java.util.List;

public class Person {

    private long id;
    private String name;
    private PhoneBook phoneBook;

    public Person(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook pbNew) {
        this.phoneBook = pbNew;
    }
}
