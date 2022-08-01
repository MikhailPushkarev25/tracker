package ru.job4j.tracker.mockTest;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenTestFindByIdMockObject() {
        OutPut out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("id Item"));
        FindByIdAction id = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn("id Item");

        id.execute(input, tracker);

        String ln = System.lineSeparator();

        assertThat(out.toString(), is("==Find item by id==" + ln + "Заявка: Item{id=1, name='id Item', create=13-июня-понедельник-2022 21:28:12}" + ln));
        assertThat(tracker.findById(1).getId(), is(1));
    }

}