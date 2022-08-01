package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final OutPut out;

    public FindByIdAction(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("==Find item by id==");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("Заявка: " + item);
        } else {
            out.println("Заявка с заявленным id: " + id + " не найдена!");
        }
        return true;
    }
}
