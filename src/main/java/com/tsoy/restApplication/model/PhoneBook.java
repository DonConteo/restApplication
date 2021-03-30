package com.tsoy.restApplication.model;

import java.util.Map;

public class PhoneBook {
    long id;
    Map<String, String> records;

    public PhoneBook(long id, Map<String, String> records) {
        this.id = id;
        this.records = records;
    }

    public PhoneBook(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, String> getRecords() {
        return records;
    }

    public void setRecords(Map<String, String> records) {
        this.records = records;
    }
}
