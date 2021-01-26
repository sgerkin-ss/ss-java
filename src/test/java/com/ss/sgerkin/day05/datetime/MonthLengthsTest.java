package com.ss.sgerkin.day05.datetime;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Month;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class MonthLengthsTest {

  @Test
  void test_getMonthLengths_ReturnsExpectedResultsForNonLeapYear() {
    var input = 2021;

    var expected = new HashMap<Month, Integer>() {
      {
        put(Month.JANUARY, 31);
        put(Month.FEBRUARY, 28);
        put(Month.MARCH, 31);
        put(Month.APRIL, 30);
        put(Month.MAY, 31);
        put(Month.JUNE, 30);
        put(Month.JULY, 31);
        put(Month.AUGUST, 31);
        put(Month.SEPTEMBER, 30);
        put(Month.OCTOBER, 31);
        put(Month.NOVEMBER, 30);
        put(Month.DECEMBER, 31);
      }
    };

    var actual = MonthLengths.getMonthLengths(input);

    assertEquals(expected.size(), actual.size());

    expected.forEach((key, value) -> {
      assertTrue(actual.containsKey(key));
      assertEquals(value, actual.get(key));
    });
  }

  @Test
  void test_getMonthLengths_ReturnsExpectedResultsForLeapYear() {
    var input = 2020;

    var expected = new HashMap<Month, Integer>() {
      {
        put(Month.JANUARY, 31);
        put(Month.FEBRUARY, 29);
        put(Month.MARCH, 31);
        put(Month.APRIL, 30);
        put(Month.MAY, 31);
        put(Month.JUNE, 30);
        put(Month.JULY, 31);
        put(Month.AUGUST, 31);
        put(Month.SEPTEMBER, 30);
        put(Month.OCTOBER, 31);
        put(Month.NOVEMBER, 30);
        put(Month.DECEMBER, 31);
      }
    };

    var actual = MonthLengths.getMonthLengths(input);

    assertEquals(expected.size(), actual.size());

    expected.forEach((key, value) -> {
      assertTrue(actual.containsKey(key));
      assertEquals(value, actual.get(key));
    });
  }
}