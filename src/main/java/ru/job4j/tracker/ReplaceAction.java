package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final OutPut out;

    public ReplaceAction(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Replace item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("== Replace item ==");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Заявка изменена успешно!");
        } else {
            out.println("Ошибка такой заявки нет!");
        }
        return true;
    }
}
