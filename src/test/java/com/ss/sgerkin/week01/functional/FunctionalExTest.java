package com.ss.sgerkin.week01.functional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class FunctionalExTest {

  private static final FunctionalEx ex = new FunctionalEx();

  /*
    getRightMostDigit
   */

  @Test
  void test_getRightMostDigit_ReturnsNewEmptyListGivenEmptyInput() {
    var input = new ArrayList<Integer>();
    var expected = new ArrayList<Integer>();
    var actual = ex.getRightMostDigit(input);

    assertEquals(expected, actual);

    // verify different lists in memory
    assertNotSame(input, actual);
    assertNotSame(expected, actual);
  }

  @Test
  void test_getRightMostDigit_ReturnsExpectedResult() {
    var input = List.of(1, 22, 93);
    var expected = List.of(1, 2, 3);
    var actual = ex.getRightMostDigit(input);

    assertEquals(expected, actual);

    input = List.of(16, 8, 886, 8, 1);
    expected = List.of(6, 8, 6, 8, 1);
    actual = ex.getRightMostDigit(input);

    assertEquals(expected, actual);

    input = List.of(10, 0);
    expected = List.of(0, 0);
    actual = ex.getRightMostDigit(input);

    assertEquals(expected, actual);
  }

  /*
    getMultipliedByTwo
   */

  @Test
  void test_getMultipliedByTwo_ReturnsNewEmptyListGivenEmptyInput() {
    var input = new ArrayList<Integer>();
    var expected = new ArrayList<Integer>();
    var actual = ex.getMultipliedByTwo(input);

    assertEquals(expected, actual);

    // verify different lists in memory
    assertNotSame(input, actual);
    assertNotSame(expected, actual);
  }

  @Test
  void test_getMultipliedByTwo_ReturnsExpectedResult() {
    var input = List.of(1, 2, 3);
    var expected = List.of(2, 4, 6);
    var actual = ex.getMultipliedByTwo(input);

    assertEquals(expected, actual);

    input = List.of(6, 8, 6, 8, -1);
    expected = List.of(12, 16, 12, 16, -2);
    actual = ex.getMultipliedByTwo(input);

    assertEquals(expected, actual);
  }

  /*
    removeX
   */

  @Test
  void test_removeX_ReturnsEmptyStringGivenEmptyInput() {
    var input = new ArrayList<String>();
    var expected = new ArrayList<String>();
    var actual = ex.removeX(input);

    assertEquals(expected, actual);

    // verify different lists in memory
    assertNotSame(input, actual);
    assertNotSame(expected, actual);
  }

  @Test
  void test_removeX_ReturnsExpectedResult() {
    var input = List.of("ax", "bb", "cx");
    var expected = List.of("a", "bb", "c");
    var actual = ex.removeX(input);

    assertEquals(expected, actual);

    input = List.of("xxax", "xbxbx", "xxcx");
    expected = List.of("a", "bb", "c");
    actual = ex.removeX(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_removeX_DoesNotRemoveUppercaseX() {
    var input = List.of("xXx", "XXX", "xxx", "aXbx");
    var expected = List.of("X", "XXX", "", "aXb");
    var actual = ex.removeX(input);

    assertEquals(expected, actual);
  }
}