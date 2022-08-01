package ru.job4j.tracker.search.stream.card;

public class Cards {

    private Suit suit;
    private Values values;

    public Cards(Suit suit, Values values) {
        this.suit = suit;
        this.values = values;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "suit=" + suit +
                ", values=" + values +
                '}';
    }
}

