package ru.job4j.tracker;

import java.util.List;

public class MainTestGc {
    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleInput()
        );
        OutPut outPut = new ConsoleOutput();
        MemTracker memTracker = new MemTracker();
            List<UserAction> actions = List.of(
                    new CreateItems(outPut),
                    new ReplaceAction(outPut),
                    new DeleteItems(outPut),
                    new ShowAction(outPut),
                    new FindByIdAction(outPut),
                    new FindByNameAction(outPut),
                    new ExitAction()
            );
            new StartUI().init(input, memTracker, actions);
    }
}
