package com.tsoy.restApplication.model;

import java.util.Map;

public class PhoneBook {

    Map<Long, Record> records;

    public PhoneBook(Map<Long, Record> records) {
        this.records = records;
    }

    public Map<Long, Record> getRecords() {
        return records;
    }
    public void setRecords(Map<Long, Record> records) {
        this.records = records;
    }
}
