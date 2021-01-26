package com.ss.sgerkin.day05.datetime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class MondayListerTest {

  @Test
  void test_getMondays_InvalidMonthThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> MondayLister.getMondays(0));
    assertThrows(IllegalArgumentException.class, () -> MondayLister.getMondays(13));
  }

  @Test
  void test_getMondays_ValidMonthDoesNotThrowException() {
    IntStream.rangeClosed(1, 12)
        .forEach(i -> assertDoesNotThrow(() -> MondayLister.getMondays(i)));

    Arrays.stream(Month.values())
        .forEach(month -> assertDoesNotThrow(() -> MondayLister.getMondays(month)));
  }

  @Test
  void test_getMondays_InvalidYearThrowsIllegalArgumentException() {
    assertThrows(IllegalArgumentException.class, () -> MondayLister.getMondays(1899, 1));
    assertThrows(IllegalArgumentException.class, () -> MondayLister.getMondays(2201, 1));
  }

  @Test
  void test_getMondays_ValidYearDoesNotThrowException() {
    IntStream.rangeClosed(1900, 2200)
        .forEach(year -> assertDoesNotThrow(() -> MondayLister.getMondays(year, 1)));
  }

  @Test
  void test_getMondays_ReturnsExpectedResult() {
    var input = 1;
    var year = 2021;
    var expected = List.of(
        LocalDate.of(year, 1, 4),
        LocalDate.of(year, 1, 11),
        LocalDate.of(year, 1, 18),
        LocalDate.of(year, 1, 25));

    var actual = MondayLister.getMondays(year, input);

    assertEquals(expected, actual);
  }

  /**
   * Edge case for February 2016 where there were 5 Mondays on a Leap year.
   */
  @Test
  void test_getMondays_ReturnsExpectedOnLeapYear() {
    var month = 2;
    var year = 2016;

    var expected = List.of(
        LocalDate.of(year, month, 1),
        LocalDate.of(year, month, 8),
        LocalDate.of(year, month, 15),
        LocalDate.of(year, month, 22),
        LocalDate.of(year, month, 29));

    var actual = MondayLister.getMondays(year, month);

    assertEquals(expected, actual);
  }
}