package com.tsoy.restApplication.model;

import java.util.List;

public class Person {

    private long id;
    private String name;

    private List<Long> phoneBook;

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

    public List<Long> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(List<Long> pbNew) {
        this.phoneBook = pbNew;
    }
}
