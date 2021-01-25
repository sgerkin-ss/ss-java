package com.ss.sgerkin.day04.line;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  void testGetSlopeHappyPathReturnsExpectedResult() {
    var line = new Line(1, 0, 2, 2);
    var expected = 2;
    var actual = line.getSlope();
    assertEquals(expected, actual);
  }

  @Test
  void testGetSlopeReturnsSameResultWithReversedOrderXAndY() {
    var line1 = new Line(1, 0, 2, 2);
    var line2 = new Line(2, 2, 1, 0);
    assertEquals(line1.getSlope(), line2.getSlope());
  }

  @Test
  void testGetSlopeNegativeDividedByNegativeYieldsPositive() {
    var line = new Line(10, 9, 2, 3);
    var expected = 6.0 / 8.0;
    var actual = line.getSlope();
    assertEquals(expected, actual);
  }

  @Test
  void testGetSlopeNegativeDividedByPositiveYieldsNegative() {
    var line = new Line(2, 9, 10, 3);
    var expected = -(6.0 / 8.0);
    var actual = line.getSlope();
    assertEquals(expected, actual);
  }

  @Test
  void testGetSlopePositiveDividedByNegativeYieldsNegative() {
    var line = new Line(10, 3, 2, 9);
    var expected = -(6.0 / 8.0);
    var actual = line.getSlope();
    assertEquals(expected, actual);
  }

  @Test
  void testDivisionByZeroThrowsArithmeticException() {
    var line = new Line(1, 2, 1, 4);
    assertThrows(ArithmeticException.class, line::getSlope);
  }

  @Test
  void testDividendOfZeroWithNonZeroDivisorDoesNotThrowException() {
    var line = new Line(1, 2, 3, 2);
    assertDoesNotThrow(line::getSlope);
  }

  @Test
  void testDividendOfZeroWithNonZeroDivisorReturns0() {
    var line = new Line(1, 2, 3, 2);
    var expected = 0;
    var actual = line.getSlope();
    assertEquals(expected, actual);
  }

  @Test
  void testGetDistanceHappyPathReturnsExpectedResult() {
    var line = new Line(1, 1, 4, 5);
    var expected = 5.0;
    var actual = line.getDistance();
    assertEquals(expected, actual);
  }

  @Test
  void testGetDistanceReturnsSameDistanceForEveryQuadrant() {
    var expected = 5.0;
    var quadrantI = new Line(1, 1, 4, 5);
    var quadrantII = new Line(-1, 1, -4, 5);
    var quadrantIII = new Line(-1, -1, -4, -5);
    var quadrantIV = new Line(1, -1, 4, -5);

    assertEquals(expected, quadrantI.getDistance());
    assertEquals(expected, quadrantII.getDistance());
    assertEquals(expected, quadrantIII.getDistance());
    assertEquals(expected, quadrantIV.getDistance());
  }

  @Test
  void testGetDistanceOfZeroReturnsZero() {
    var line = new Line(0, 0, 0, 0);
    var expected = 0;
    var actual = line.getDistance();
    assertEquals(expected, actual);
  }

  @Test
  void testIsParallelReturnsTrueForSamePoints() {
    var line1 = new Line(1, 1, 4, 5);
    var line2 = new Line(1, 1, 4, 5);
    assertTrue(line1.isParallel(line2));
  }

  @Test
  void testIsParallelReturnsTrueForContinuationOfSameLine() {
    var line1 = new Line(1, 1, 4, 5);
    var line2 = new Line(6, 6, 9, 10);
    assertTrue(line1.isParallel(line2));
  }

  @Test
  void testIsParallelReturnsTrueForLineIsParallelToItself() {
    var line1 = new Line(0, 0, 3, 4);
    var line2 = new Line(0, 0, 3, 4);
    assertTrue(line1.isParallel(line2));
  }

  @Test
  void testIsParallelReturnsTrueForDifferentLinesWithSameSlope() {
    var line1 = new Line(0, 0, 3, 4);
    var line2 = new Line(5, 5, 8, 9);
    assertTrue(line1.isParallel(line2));
  }

  @Test
  void testIsParallelReturnsFalseForIntersection() {
    var line1 = new Line(0, 0, 3, 4);
    var line2 = new Line(3, 0, 0, 4);
    assertFalse(line1.isParallel(line2));
  }

  @Test
  void testIsParallelReturnsFalseForIntersectionOutsideOfGivenPoints() {
    var line1 = new Line(0, 0, 3, 4);
    var line2 = new Line(10, 10, 9, 9);
    assertFalse(line1.isParallel(line2));
  }

}
