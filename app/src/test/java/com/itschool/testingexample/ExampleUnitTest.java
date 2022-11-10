package com.itschool.testingexample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(Parameterized.class)
public class ExampleUnitTest {

    @Parameterized.Parameters
    public static Collection<Integer[]> getData() {
        return Arrays.asList(new Integer[][]{{2, 4}, {3, 6}, {4, 8}, {5, 10}});
    }

    @Parameterized.Parameter
    public int input;

    @Parameterized.Parameter(1)
    public int output;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void parametrized_isCorrect() {
        assertEquals(output, input + input);
    }
}