package ru.job4j.tracker;

public class CreateItems implements UserAction {

    private final OutPut out;

    public CreateItems(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        Item item = null;
        out.println("== Create a new item ===");
        String name = input.askStr("Enter name: ");
        for (int i = 1; i < 1_000_000_000; i++) {
            item = new Item(name);
            tracker.add(item);
        }
        System.out.println("Добавлена заявка: " + item);
        return true;
    }
}
