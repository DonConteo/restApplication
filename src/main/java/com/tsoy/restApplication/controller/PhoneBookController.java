package com.tsoy.restApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/phones")
public class PhoneBookController {

//    public List<Map<String, String>> phones = new ArrayList<Map<String, String>>(){{
//        add(new HashMap<String, String>() {{ put("number", "890"); put("contact", "kotik"); }});
//        add(new HashMap<String, String>() {{ put("number", "8901"); put("contact", "doggo"); }});
//        add(new HashMap<String, String>() {{ put("number", "8902"); put("contact", "parrot"); }});
//    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return phones;
    }

    @GetMapping("/contact/{contact}")
    public Map<String, String> getByContact(@PathVariable(value = "contact") String contact){
        return phones.stream()
                .filter(note -> note.get("contact").equals(contact))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/number/{number}")
    public Map<String, String> getByNumber(@PathVariable(value = "number") String number){
        return phones.stream()
                .filter(note -> note.get("number").equals(number))
                .findFirst()
                .orElseThrow();
    }
}
