package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {

    private final OutPut out;

    public ShowAction(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Show all items ==");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("В хранилище заявок пока нет!");
        }
        return true;
    }
}
