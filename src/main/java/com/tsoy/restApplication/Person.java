package com.tsoy.restApplication;

import java.util.List;
import java.util.Map;

public class Person {

    long id;
    String name;
    List<Map<String, String>> phones;

    public Person(long id, String name, List<Map<String, String>> notes) {
        this.id = id;
        this.name = name;
        this.phones = notes;
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

    public List<Map<String, String>> getPhones() {
        return phones;
    }
    public void setPhones(List<Map<String, String>> phones) {
        this.phones = phones;
    }
}
