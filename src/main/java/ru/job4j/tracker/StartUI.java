package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    private OutPut out;

    public StartUI() {
    }

    public StartUI(OutPut out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size()));
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        int i = 0;
        System.out.println("Menu.");
        for (UserAction action : actions) {
            System.out.println(i++ + ". " + action.name());
        }
    }

    public static void main(String[] args) {
       Input input = new ValidateInput(
               new ConsoleInput()
       );
       OutPut outPut = new ConsoleOutput();
       try (SqlTracker sqlTracker = new SqlTracker()) {
           sqlTracker.init();
           List<UserAction> actions = List.of(
                   new CreateAction(outPut),
                   new ReplaceAction(outPut),
                   new DeleteAction(outPut),
                   new ShowAction(outPut),
                   new FindByIdAction(outPut),
                   new FindByNameAction(outPut),
                   new ExitAction()
           );
           new StartUI().init(input, sqlTracker, actions);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
