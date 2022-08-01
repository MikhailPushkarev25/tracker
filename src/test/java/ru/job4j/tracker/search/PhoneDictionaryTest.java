package ru.job4j.tracker.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(
                new Person("Mikhail", "Pushkarev", "234-345", "prospect Lenina")
        );
        ArrayList<Person> people = phoneDictionary.find("Mikhail");
        assertThat(people.get(0).getSurname(), is("Pushkarev"));
    }
}