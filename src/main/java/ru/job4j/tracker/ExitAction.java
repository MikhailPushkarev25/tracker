package ru.job4j.tracker;

import java.util.Scanner;

public class ExitAction implements UserAction {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String name() {
        return "Exit program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
