package com.ss.sgerkin.day05.datetime;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class PreviousThursdayFinderTest {

  @Test
  void test_findPreviousThursday_ReturnsPreviousThursdayIfGivenAThursday() {
    var input = LocalDate.of(2021, 1, 28);
    var expected = LocalDate.of(2021, 1, 21);
    var actual = PreviousThursdayFinder.findPreviousThursday(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_findPreviousThursday_ReturnsCorrectDayGivenFriday() {
    var input = LocalDate.of(2021, 1, 29);
    var expected = LocalDate.of(2021, 1, 28);
    var actual = PreviousThursdayFinder.findPreviousThursday(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_findPreviousThursday_ReturnsSameResponseForEntireWeek() {
    var startOnFriday = LocalDate.of(2021, 1, 29);
    var expected = LocalDate.of(2021, 1, 28);

    IntStream.rangeClosed(0, 6).forEach(i -> {
      var input = startOnFriday.plusDays(i);
      var actual = PreviousThursdayFinder.findPreviousThursday(input);

      assertEquals(expected, actual);
    });
  }
}