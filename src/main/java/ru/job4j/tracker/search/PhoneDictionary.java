package ru.job4j.tracker.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> one = (s) -> s.getName().contains(key) || s.getSurname().contains(key);
        Predicate<Person> two = (s) -> s.getAddress().contains(key) || s.getPhone().contains(key);
        Predicate<Person> combine = one.or(two);
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                people.add(person);
            }
        }
        return people;
    }
}
