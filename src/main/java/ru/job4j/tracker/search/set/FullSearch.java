package ru.job4j.tracker.search.set;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> set = new HashSet<>();
        for (Task task : list) {
                set.add(task.getNumber());
        }
        return set;
    }
}
