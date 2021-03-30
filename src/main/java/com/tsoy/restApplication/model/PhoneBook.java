package com.tsoy.restApplication.model;

public class PhoneBook {

    long contactId;
    String number;
    String contactName;

    public PhoneBook(long contactId, String number, String contactName) {
        this.contactId = contactId;
        this.number = number;
        this.contactName = contactName;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}