package ru.job4j.tracker.mockTest;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenTestFindByNameMock() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "Find by name";
        tracker.add(new Item(name));
        FindByNameAction nameAction = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn("Find by name");

        nameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==Find item by name==" + ln + "Заявка - 1 Find by name" + ln));
        assertThat(tracker.findByName(name), is(1));
    }

}