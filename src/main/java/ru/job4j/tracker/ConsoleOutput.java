package ru.job4j.tracker;

public class ConsoleOutput implements OutPut {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
