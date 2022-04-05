package pl.javastart.junittestingcourse.examples.mockitoverify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MockitoVerifyExample {

    @Test
    void verifyExample() {
        MyClass mock = mock(MyClass.class);

        mock.myMethod();
        mock.myMethod();

        verify(mock, times(2)).myMethod();

    }
}
