package ru.job4j.tracker.mockTest;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteActionTest {

    @Test
    public void whenTestDeleteItem() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Delete line"));
        DeleteAction deleteAction = new DeleteAction(out);

        Input input = mock(Input.class);


        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("==Delete item==" + ln + "Заявка успешно удалена!" + ln));
        assertThat(tracker.findAll().size(), is(0));
    }
}