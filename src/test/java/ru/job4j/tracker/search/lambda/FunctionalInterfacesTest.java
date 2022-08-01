package ru.job4j.tracker.search.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionalInterfacesTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionalInterfaces.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

}