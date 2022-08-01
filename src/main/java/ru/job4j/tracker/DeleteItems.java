package ru.job4j.tracker;

public class DeleteItems implements UserAction {

    private final OutPut out;

    public DeleteItems(OutPut out) {
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
        for (int i = 1; i < id; i++) {
            if (tracker.delete(i)) {
                out.println("Заявка успешно удалена!");
            } else {
                out.println("Произошла ошибка при удалении заявки!");
            }
        }
        return true;
    }
}
