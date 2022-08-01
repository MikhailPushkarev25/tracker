package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final OutPut out;

    public CreateAction(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Create a new item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавлена заявка: " + item);
        return true;
    }
}
