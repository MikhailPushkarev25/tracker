package ru.job4j.tracker.search.set;

import java.util.HashSet;
import java.util.Set;

public class UniqueText {

    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        Set<String> check = new HashSet<>();
        for (String original : origin) {
            check.add(original);
        }
            for (String text : duplicate) {
                if (!check.contains(text)) {
                    rsl = false;
                    break;
                }
            }
        return rsl;

    }
}
