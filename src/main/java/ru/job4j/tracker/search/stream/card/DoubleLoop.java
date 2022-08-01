package ru.job4j.tracker.search.stream.card;

import java.util.stream.Stream;

public class DoubleLoop {
    public static void main(String[] args) {


        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Values.values())
                .map(value -> new Cards(suit, value)))
                .forEach(System.out::println);
    }
}
