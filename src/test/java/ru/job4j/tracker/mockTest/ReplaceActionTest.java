package ru.job4j.tracker.mockTest;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReplaceActionTest {

    @Test
    public void example() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replaceName = "New item name";
        ReplaceAction replace = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replaceName);

        replace.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("== Replace item ==" + ln + "Заявка изменена успешно!" + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replaceName));
    }
}