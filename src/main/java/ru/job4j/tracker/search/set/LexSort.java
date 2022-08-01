package ru.job4j.tracker.search.set;

import java.util.Arrays;
import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] lft = left.split("\\.");
        String[] rht = right.split("\\.");
        return Integer.parseInt(lft[0]) - Integer.parseInt(rht[0]);
    }
}
