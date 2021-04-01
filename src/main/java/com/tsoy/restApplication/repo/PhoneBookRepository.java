package com.tsoy.restApplication.repo;

import com.tsoy.restApplication.model.PhoneBook;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class PhoneBookRepository {

    public PhoneBook create() {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        return phoneBook;
    }
}
