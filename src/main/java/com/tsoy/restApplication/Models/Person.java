package com.tsoy.restApplication.Models;

import java.util.List;

public class Person {

    private long id;
    private String name;
    private List<PhoneBook> phoneBook;

    public Person(long id, String name, List<PhoneBook> phoneBook) {
        this.id = id;
        this.name = name;
        this.phoneBook = phoneBook;
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

    public List<PhoneBook> getPhoneBook() {
        return phoneBook;
    }
    public void setPhoneBook(List<PhoneBook> phoneBook) {
        this.phoneBook = phoneBook;
    }
}
