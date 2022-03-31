package pl.javastart.junittestingcourse.examples;

import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("fast")
public class CalculatorTest {

    @DisplayName("5 + 2 = 7")
    @Test
    public void shouldAdd5To2AndResult7() {
        //given
        Calculator calculator = new Calculator();
        int a = 5;
        int b = 2;

        //when
        int result = calculator.add(a, b);

        //then
        assertEquals(7, result);
    }

    @Test
    public void shouldAdd1To1AndResult2() {
        //given
        Calculator calculator = new Calculator();
        int a = 1;
        int b = 1;

        //when
        int result = calculator.add(a, b);

        //then
        assertEquals(3, result);
    }


}