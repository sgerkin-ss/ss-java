package com.ss.sgerkin.week01.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class RecursionExTest {

  private static final RecursionEx ex = new RecursionEx();

  /*
    groupSumClump
   */

  @Test
  void test_groupSumClump_ReturnsFalseIfMultipleRunsArePresent() {
    var input = List.of(1, 1, 2, 3, 3);
    var inputTarget = 2;

    var result = ex.groupSumClump(input, inputTarget);
    assertFalse(result);

    inputTarget = 6;
    result = ex.groupSumClump(input, inputTarget);
    assertFalse(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForSingleItemEqualToTarget() {
    var inputList = List.of(1);
    var inputTarget = 1;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForTwoDuplicateItemsSummedToTarget() {
    var inputList = List.of(1, 1);
    var inputTarget = 2;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForRunOfTwoAtStartEqualsTarget() {
    var inputList = List.of(1, 1, 2, 3);
    var inputTarget = 2;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForRunOfTwoInMiddleEqualsTarget() {
    var inputList = List.of(1, 2, 2, 3);
    var inputTarget = 4;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForRunOfTwoAtEndEqualsTarget() {
    var inputList = List.of(1, 2, 3, 3);
    var inputTarget = 6;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }



  @Test
  void test_groupSumClump_ReturnsTrueForListWithRunSummingToTarget() {
    var inputList = List.of(1, 2, 2, 2, 5, 2);
    var inputTarget = 6;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForNoRunButSumsToTarget() {
    var inputList = List.of(2, 4, 8);
    var inputTarget = 10;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsTrueForDuplicateItemsNotInRunButSubsetSumsToTarget() {
    var inputList = List.of(1, 2, 4, 8, 1);
    var inputTarget = 14;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertTrue(result);
  }

  @Test
  void test_groupSumClump_ReturnsFalseForListWithRunNotSummingToTarget() {
    var inputList = List.of(2, 4, 4, 8);
    var inputTarget = 14;

    var result = ex.groupSumClump(inputList, inputTarget);
    assertFalse(result);
  }

  /*
    isRun
   */

  @Test
  void test_isRun_ReturnsTrueWithListOfSingleItem() {
    var input = List.of(1);

    var result = ex.isRun(input);
    assertTrue(result);
  }

  @Test
  void test_isRun_ReturnsTrueForListOfOnlyRun() {
    var input = List.of(1, 1, 1);

    var result = ex.isRun(input);
    assertTrue(result);
  }

  @Test
  void test_isRun_ReturnsFalseForListContainingRunAndAdditionalNumbers() {
    var input = List.of(1, 1, 1, 2);

    var result = ex.isRun(input);
    assertFalse(result);
  }

  @Test
  void test_isRun_ReturnsFalseForListContainingAllDistinctNumbers() {
    var input = List.of(1, 2, 3, 4, 5);

    var result = ex.isRun(input);
    assertFalse(result);
  }

  @Test
  void test_isRun_ReturnsFalseForDuplicateItemsSeparatedByADifferentValue() {
    var input = List.of(1, 2, 1);

    var result = ex.isRun(input);
    assertFalse(result);
  }

  @Test
  void test_isRun_ReturnsFalseForEmptyList() {
    var input = new ArrayList<Integer>();

    var result = ex.isRun(input);
    assertFalse(result);
  }

  /*
    listSumEqualsTarget
   */

  @Test
  void test_listSumEqualsTarget_ReturnsTrueForEmptyListEquals0() {
    var input = new ArrayList<Integer>();
    var target = 0;

    var result = ex.listSumEqualsTarget(input, target);
    assertTrue(result);
  }

  @Test
  void test_listSumEqualsTarget_ReturnsTrueForSingleItem() {
    var input = List.of(1);
    var target = 1;

    var result = ex.listSumEqualsTarget(input, target);
    assertTrue(result);
  }

  @Test
  void test_listSumEqualsTarget_ReturnsTrueForTwoItems() {
    var input = List.of(1, 1);
    var target = 2;

    var result = ex.listSumEqualsTarget(input, target);
    assertTrue(result);
  }

  /*
    containsRun
   */

  @Test
  void test_containsRun_ReturnsFalseForSingleItem() {
    var input = List.of(1);

    var result = ex.containsRun(input);
    assertFalse(result);
  }

  @Test
  void test_containsRun_ReturnsTrueForMultipleRuns() {
    var input = List.of(1, 1, 2, 3, 3, 4);

    var result = ex.containsRun(input);
    assertTrue(result);
  }

  @Test
  void test_containsRun_ReturnsTrueForRunAtStartOfList() {
    var input = List.of(1, 1, 2, 3);

    var result = ex.containsRun(input);
    assertTrue(result);
  }

  @Test
  void test_containsRun_ReturnsTrueForRunInMiddleOfList() {
    var input = List.of(1, 2, 2, 3);

    var result = ex.containsRun(input);
    assertTrue(result);
  }

  @Test
  void test_containsRun_ReturnsTrueForRunAtEndOfList() {
    var input = List.of(1, 2, 3, 3);

    var result = ex.containsRun(input);
    assertTrue(result);
  }

  @Test
  void test_containsRun_ReturnsFalseForNoRunWithAllDistinctItems() {
    var input = List.of(1, 2, 3);

    var result = ex.containsRun(input);
    assertFalse(result);
  }

  @Test
  void test_containsRun_ReturnsFalseForNoRunWithDuplicateItems() {
    var input = List.of(1, 2, 3, 4, 1, 2, 3, 4);

    var result = ex.containsRun(input);
    assertFalse(result);
  }

  /*
    findRun
   */

  @Test
  void test_findRun_ThrowsExceptionOnEmptyList() {
    assertThrows(IllegalArgumentException.class, () -> ex.findRun(Collections.emptyList()));
  }

  @Test
  void test_findRun_ThrowsExceptionOnListWithSingleItem() {
    var input = List.of(1);

    assertThrows(IllegalArgumentException.class, () -> ex.findRun(input));
  }

  @Test
  void test_findRun_ThrowsExceptionOnListWithoutRun() {
    var input = List.of(1, 2, 3, 4);

    assertThrows(IllegalArgumentException.class, () -> ex.findRun(input));
  }

  @Test
  void test_findRun_ReturnsNewListOfRunAtStartOfList() {
    var input = List.of(1, 1, 2, 3);
    var expected = List.of(1, 1);
    var actual = ex.findRun(input);

    assertEquals(expected, actual);

    assertNotSame(actual, expected);
    assertNotSame(actual, input);
  }

  @Test
  void test_findRun_ReturnsNewListOfRunFromMiddleOfList() {
    var input = List.of(1, 2, 2, 3);
    var expected = List.of(2, 2);
    var actual = ex.findRun(input);

    assertEquals(expected, actual);

    assertNotSame(actual, expected);
    assertNotSame(actual, input);
  }

  @Test
  void test_findRun_ReturnsNewListOfRunFromEndOfList() {
    var input = List.of(1, 2, 3, 3);
    var expected = List.of(3, 3);
    var actual = ex.findRun(input);

    assertEquals(expected, actual);

    assertNotSame(actual, expected);
    assertNotSame(actual, input);
  }

  @Test
  void test_findRun_DoesNotCollectItemsNotInRun() {
    var input = List.of(1,2,2,5,2);
    var expected = List.of(2,2);
    var actual = ex.findRun(input);

    assertEquals(expected, actual);

    assertNotSame(actual, expected);
    assertNotSame(actual, input);
  }
}