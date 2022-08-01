package ru.job4j.tracker.search.lambda;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        double rsl = 0;
        List<Double> list = new ArrayList<>();
        for (int index = start; index < end; index++) {
            rsl = index;
            list.add(func.apply(rsl));
        }
        return list;
    }

    public static void main(String[] args) {
    }
}
