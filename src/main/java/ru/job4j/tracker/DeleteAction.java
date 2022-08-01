package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final OutPut out;

    public DeleteAction(OutPut out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("==Delete item==");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Заявка успешно удалена!");
        } else {
            out.println("Произошла ошибка при удалении заявки!");
        }
        return true;
    }
}
