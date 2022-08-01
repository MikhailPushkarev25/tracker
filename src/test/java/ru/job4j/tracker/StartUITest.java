package ru.job4j.tracker;


import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StartUITest {

    @Test
    public void whenCreateItem() {
        OutPut out = new ConsoleOutput();
        Input in = new StubInput(new String[] {
                "0", "new Item", "1"
        });
        MemTracker tracker = new MemTracker();
        List<UserAction> action = List.of(
                new CreateAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findAll(), is("new Item"));
    }

    @Test
    public void whenReplaceItem() {
        OutPut out = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replace item"));
        String replacedName = "New replace name";
        Input in = new StubInput(
                new String[] {
                        "0",
                        String.valueOf(item.getId()),
                        replacedName,
                        "1"
                }
        );
        List<UserAction> action = List.of(
                new ReplaceAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        OutPut out = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(
                new String[] {
                        "0",
                        String.valueOf(item.getId()),
                        "1"
        }
        );
        List<UserAction> action = List.of(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        OutPut out = new StubOutput();
        Input in = new StubInput(
                new String[] {
                        "0"
                }
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> action = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(""));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessFull() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "new item name";
        Input in = new StubInput(
                new String[] {
                        "0",
                        String.valueOf(one.getId()),
                        replaceName,
                        "1"
        }
        );
        List<UserAction> action = List.of(
                new ReplaceAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(
                "== Replace item ==\r\nЗаявка изменена успешно!\r\n"
        ));
    }

    @Test
    public void whenFindAllItemTestOutputIsSuccessFull() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(
                new String[] {
                       "0",
                       "1"
                }
        );
        List<UserAction> action = List.of(
                new ShowAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(
                "== Show all items ==\r\nВ хранилище заявок пока нет!\r\n"
        ));
    }

    @Test
    public void whenFindByNameItemTestOutputIsSuccessFull() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(
                new String[] {
                        "0",
                        "1"
                }
        );
        List<UserAction> action = List.of(
                new FindByNameAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(
                "==Find item by name==\r\nТакой заявки не существует!\r\n"));
    }

    @Test
    public void whenFindByIdActionItemTestOutputIsSuccessFull() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Input in = new StubInput(new String[] {
                "0",
                String.valueOf(new Item().getId()),
                "1"
        });
        List<UserAction> action = List.of(
                new FindByIdAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(
                "==Find item by id==\r\nЗаявка с заявленным id: 0 не найдена!\r\n"));
    }

    @Test
    public void whenInvalidExit() {
        OutPut out = new StubOutput();
        Input in = new StubInput(new String[] {
                "0", "text"
        });
        MemTracker tracker = new MemTracker();
        List<UserAction> action = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString(), is(""));
    }
}