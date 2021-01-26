package com.ss.sgerkin.day05.datetime;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class SpookyFridayCheckerTest {

  @Test
  void test_isFridayThe13th_ReturnsTrueForFridayThe13th() {
    var input = LocalDate.of(2020, 3, 13);
    assertTrue(SpookyFridayChecker.isFridayThe13th(input));

    input = LocalDate.of(2020, 11, 13);
    assertTrue(SpookyFridayChecker.isFridayThe13th(input));
  }

  @Test
  void test_isFridayThe13th_ReturnsFalseForFridayNot13th() {
    var input = LocalDate.of(2020, 3, 20);
    assertFalse(SpookyFridayChecker.isFridayThe13th(input));

    input = LocalDate.of(2020, 11, 20);
    assertFalse(SpookyFridayChecker.isFridayThe13th(input));
  }

  @Test
  void test_isFridayThe13th_ReturnsFalseFor13thNotOnAFriday() {
    var input = LocalDate.of(2021, 1, 13);
    assertFalse(SpookyFridayChecker.isFridayThe13th(input));
  }
}