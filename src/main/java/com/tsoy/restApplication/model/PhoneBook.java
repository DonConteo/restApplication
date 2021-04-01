package com.tsoy.restApplication.model;

import java.util.Map;

public class PhoneBook {

    Map<String, String> records;

    public PhoneBook(Map<String, String> records) {
        this.records = records;
    }

    public Map<String, String> getRecords() {
        return records;
    }
    public void setRecords(Map<String, String> records) {
        this.records = records;
    }
}
