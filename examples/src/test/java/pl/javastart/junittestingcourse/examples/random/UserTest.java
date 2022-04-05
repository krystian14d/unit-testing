package pl.javastart.junittestingcourse.examples.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserTest {

    @Mock
    DateTimeProvider dateTimeProvider;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldBeOlderThanAYear() {
        //given
        ZonedDateTime userCreationDate = ZonedDateTime.of(2021, 04, 04, 15,
                0, 0, 0, ZoneId.of("Europe/Warsaw"));

        User user = new User("Ania", userCreationDate);

        ZonedDateTime now = ZonedDateTime.of(2022, 04, 05, 15,
                0, 0, 0, ZoneId.of("Europe/Warsaw"));

        when(dateTimeProvider.nowAsZonedDateTime()).thenReturn(now);

        //when
        boolean olderThanAYear = user.isOlderThanAYear(dateTimeProvider);

        //then
        assertThat(olderThanAYear).isTrue();
    }

    @Test
    void shouldNotBeOlderThanAYear() {
        //given
        ZonedDateTime userCreationDate = ZonedDateTime.of(2021, 04, 04, 15,
                0, 0, 0, ZoneId.of("Europe/Warsaw"));

        User user = new User("Ania", userCreationDate);

        ZonedDateTime now = ZonedDateTime.of(2022, 03, 05, 15,
                0, 0, 0, ZoneId.of("Europe/Warsaw"));

        when(dateTimeProvider.nowAsZonedDateTime()).thenReturn(now);

        //when
        boolean olderThanAYear = user.isOlderThanAYear(dateTimeProvider);

        //then
        assertThat(olderThanAYear).isFalse();
    }
}