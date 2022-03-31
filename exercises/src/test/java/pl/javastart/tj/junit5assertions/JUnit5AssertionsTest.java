package pl.javastart.tj.junit5assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnit5AssertionsTest {

    //given
    JUnit5Assertions sut = new JUnit5Assertions();

    @Test
    public void shouldBePrimeFor1() {

        //when
        boolean result = sut.isPrimeNumber(1);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor2() {

        //when
        boolean result = sut.isPrimeNumber(2);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor10() {

        //when
        boolean result = sut.isPrimeNumber(10);

        //then
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldBePrimeFor11() {

        //when
        boolean result = sut.isPrimeNumber(11);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor13() {

        //when
        boolean result = sut.isPrimeNumber(13);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldReturnValidCode(){

        //when
        JUnit5Assertions.Code code = sut.getCode("a");

        //then
        Assertions.assertEquals("a", code.getKey());
        Assertions.assertNotNull(code.getCreatedAtTimestamp());
        Assertions.assertNotNull(code.getCode());
    }

    @Test
    public void shouldReturnSameObjects(){

        //when
        JUnit5Assertions.Code code = sut.getCode("a");
        JUnit5Assertions.Code code2 = sut.getCode("a");

        //then
        Assertions.assertSame(code, code2);
    }

    @Test
    public void shouldReturnDifferentObjects(){

        //when
        JUnit5Assertions.Code code = sut.getCode("a");
        JUnit5Assertions.Code code2 = sut.getCode("b");

        //then
        Assertions.assertNotSame(code, code2);
    }

}
