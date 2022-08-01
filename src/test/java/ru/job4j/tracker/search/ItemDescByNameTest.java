package ru.job4j.tracker.search;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void whenTestDescName() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("a");
        Item item1 = new Item("b");
        Item item2 = new Item("c");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.sortNameDescending();
        List<Item> list =  tracker.findAll();;

        assertThat(list.get(0).getName(), is(item2.getName()));
        assertThat(list.get(1).getName(), is(item1.getName()));
        assertThat(list.get(2).getName(), is(item.getName()));
    }

    @Test
    public void whenTestAscName() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("a");
        Item item1 = new Item("b");
        Item item2 = new Item("c");
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.sortNameAscending();
        List<Item> list =  tracker.findAll();;

        assertThat(list.get(0).getName(), is(item.getName()));
        assertThat(list.get(1).getName(), is(item1.getName()));
        assertThat(list.get(2).getName(), is(item2.getName()));
    }

}