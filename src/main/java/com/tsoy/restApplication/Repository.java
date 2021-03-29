//package com.tsoy.restApplication;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Repository {
//
//    static List<Person> persons = new ArrayList<Person>();
//
//    static {
//        Person person1 = new Person(1, "nikolay", new ArrayList<Map<String, String>>() {{
//            add(new HashMap<String, String>() {{ put("number", "890"); put("contact", "kotik"); }});
//            add(new HashMap<String, String>() {{ put("number", "8901"); put("contact", "doggo"); }});
//            add(new HashMap<String, String>() {{ put("number", "8902"); put("contact", "parrot"); }});
//        }});
//        persons.add(person1);
//    }
//
//    public Person personById(long id){
//        return persons.get((int) id);
//    }
//}
