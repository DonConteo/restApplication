package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.Person;
import com.tsoy.restApplication.model.PhoneBook;

import java.util.ArrayList;
import java.util.List;

public class Repository{

    static List<Person> persons = new ArrayList<>();
    static List<PhoneBook> phoneBooks = new ArrayList<>();

    static {
        PhoneBook phoneBook1 = new PhoneBook(1, "123", "doggo1");
        PhoneBook phoneBook2 = new PhoneBook(2, "1234", "doggo2");
        PhoneBook phoneBook3 = new PhoneBook(3, "12345", "doggo3");
        PhoneBook phoneBook4 = new PhoneBook(4, "123456", "doggo4");
        PhoneBook phoneBook5 = new PhoneBook(5, "1234567", "doggo5");
        PhoneBook phoneBook6 = new PhoneBook(6, "12345678", "doggo6");
        phoneBooks.add(phoneBook1);
        phoneBooks.add(phoneBook2);
        phoneBooks.add(phoneBook3);
        phoneBooks.add(phoneBook4);
        phoneBooks.add(phoneBook5);
        phoneBooks.add(phoneBook6);
        persons.add(new Person(1, "Vasya", new ArrayList<>(){{
            add(phoneBook1);
            add(phoneBook2);
            add(phoneBook3);
        }}));
        persons.add(new Person(2, "Petya", new ArrayList<>(){{
            add(phoneBook4);
            add(phoneBook5);
            add(phoneBook6);
        }}));
    }

    public List<Person> persons(){
        return persons;
    }

    public List<PhoneBook> phoneBooks(){
        return phoneBooks;
    }

    public Person personById(long id){
        return persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public Person personByName(String name){
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }

    public PhoneBook phoneBookById(long contactId){
        return phoneBooks.stream()
                .filter(phoneBook -> phoneBook.getContactId() == contactId)
                .findFirst()
                .orElseThrow();
    }

    public PhoneBook phoneByNumber(String number){
        return phoneBooks.stream()
                .filter(phonebook -> phonebook.getNumber().equals(number))
                .findFirst()
                .orElseThrow();
    }

    public PhoneBook phoneByName(String contactName){
        return phoneBooks.stream()
                .filter(phonebook -> phonebook.getContactName().equals(contactName))
                .findFirst()
                .orElseThrow();
    }

    public void createPerson(long id, String name){
        for(int i = 0; i < persons.size(); i++){
            if(id == persons.get(i).getId()){
                break;
            }
            else {
                Person pers = new Person(id, name, new ArrayList<>());
                persons.add(pers);
            }
        }
    }

    public void deletePerson(long id){
        Person p = persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElseThrow();
        persons.remove(p);
        p = null;
    }
}
