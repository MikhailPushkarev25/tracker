package ru.job4j.tracker.search.set;

public class Task {

    private final String number;
    private final String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}
