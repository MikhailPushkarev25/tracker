package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        OutPut out = new StubOutput();
        Input in = new StubInput(new String[] {"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenAccessInput() {
        OutPut out = new StubOutput();
        Input in = new StubInput(new String[] {"1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenAccessResultInput() {
        OutPut out = new StubOutput();
        String[] str = new String[] {"0", "1", "2", "3"};
        Input in = new StubInput(str);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
        int selected3 = input.askInt("Enter menu:");
        assertThat(selected, is(0));
        assertThat(selected1, is(1));
        assertThat(selected2, is(2));
        assertThat(selected3, is(3));
    }

    @Test
    public void whenInvalidResultInput() {
        OutPut out = new StubOutput();
        String[] str = new String[] {"-1", "0"};
        Input in = new StubInput(str);
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-1));
    }
}