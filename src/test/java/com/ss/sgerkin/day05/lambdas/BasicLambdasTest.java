package com.ss.sgerkin.day05.lambdas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class BasicLambdasTest {

  private static final Random random = new Random(8);

  @Test
  void junitSanityTestAssertEqualsOnListRespectsOrdering() {
    var list = List.of("a", "bb", "ccc", "dddd");
    var sameOrder = List.of("a", "bb", "ccc", "dddd");
    var reversed = List.of("dddd", "ccc", "bb", "a");

    assertEquals(list, sameOrder);
    assertNotEquals(list, reversed);
  }

  /*
    sortByLength
   */

  @Test
  void test_sortByLength_ReturnsSameListIfAlreadySortedByLength() {
    var expected = List.of("a", "bb", "ccc", "dddd");
    var actual = BasicLambdas.sortByLength(expected);
    assertEquals(expected, actual);

    var reversed = List.of("dddd", "ccc", "bb", "a");
    assertNotEquals(reversed, actual);
  }

  @Test
  void test_sortByLength_ReturnsExpectedResult() {
    var input = List.of("dddd", "a", "bb", "ccc");
    var expected = List.of("a", "bb", "ccc", "dddd");
    var actual = BasicLambdas.sortByLength(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByLength_ReturnsEmptyStringsAsFirstItems() {
    var input = List.of("a", "", "bb");
    var expected = List.of("", "a", "bb");
    var actual = BasicLambdas.sortByLength(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_sortByLength_SortsCorrectlyGivenMultipleStringsOfSameLength() {
    var input = List.of("a", "b", "cc", "dd", "eee", "f", "gg", "hhh");

    var actual = BasicLambdas.sortByLength(input);

    // should have first 3 items as length 1
    assertEquals(1, actual.get(0).length());
    assertEquals(1, actual.get(1).length());
    assertEquals(1, actual.get(2).length());

    // next 3 should be length 2
    assertEquals(2, actual.get(3).length());
    assertEquals(2, actual.get(4).length());
    assertEquals(2, actual.get(5).length());

    // last 2 should be length 3
    assertEquals(3, actual.get(6).length());
    assertEquals(3, actual.get(7).length());

    // length of both lists should be equal
    assertEquals(input.size(), actual.size());

    // actual should contain all items from input
    input.forEach(item -> assertTrue(actual.contains(item)));
  }

  /*
    shortByLengthReversed
   */

  @Test
  void test_sortByLengthReversed_ReturnsSameListIfAlreadySortedByLengthReversed() {
    var expected = List.of("dddd", "ccc", "bb", "a");
    var actual = BasicLambdas.sortByLengthReversed(expected);
    assertEquals(expected, actual);

    var reversed = List.of("a", "bb", "ccc", "dddd");
    assertNotEquals(reversed, actual);
  }

  @Test
  void test_sortByLengthReversed_ReturnsExpectedResult() {
    var input = List.of("a", "bb", "ccc", "dddd");
    var expected = List.of("dddd", "ccc", "bb", "a");
    var actual = BasicLambdas.sortByLengthReversed(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByLengthReversed_ReturnsEmptyStringsAsLastItems() {
    var input = List.of("a", "", "bb");
    var expected = List.of("bb", "a", "");
    var actual = BasicLambdas.sortByLengthReversed(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_sortByLengthReversed_SortsCorrectlyGivenMultipleStringsOfSameLength() {
    var input = List.of("a", "b", "cc", "dd", "eee", "f", "gg", "hhh");

    var actual = BasicLambdas.sortByLengthReversed(input);

    // first 2 should be length 3
    assertEquals(3, actual.get(0).length());
    assertEquals(3, actual.get(1).length());

    // next 3 should be length 2
    assertEquals(2, actual.get(2).length());
    assertEquals(2, actual.get(3).length());
    assertEquals(2, actual.get(4).length());

    // last 3 should be length 1
    assertEquals(1, actual.get(5).length());
    assertEquals(1, actual.get(6).length());
    assertEquals(1, actual.get(7).length());

    // length of both lists should be equal
    assertEquals(input.size(), actual.size());

    // actual should contain all items from input
    input.forEach(item -> assertTrue(actual.contains(item)));
  }
  
  /*
    sortByFirstCharacter
   */

  @Test
  void test_sortByFirstCharacter_DoesNotThrowExceptionOnEmptyString() {
    var input = List.of("");
    assertDoesNotThrow(() -> BasicLambdas.sortByFirstCharacter(input));
  }

  @Test
  void test_sortByFirstCharacter_ReturnsExpectedResult() {
    var expected = List.of("Alpha",
                           "Bravo",
                           "Charlie",
                           "Delta",
                           "Echo",
                           "Foxtrot",
                           "Golf",
                           "Hotel",
                           "India",
                           "Juliet",
                           "Kilo",
                           "Lima",
                           "Mike",
                           "November",
                           "Oscar",
                           "Papa",
                           "Quebec",
                           "Romeo",
                           "Sierra",
                           "Tango",
                           "Uniform",
                           "Victor",
                           "Whiskey",
                           "X-ray",
                           "Yankee",
                           "Zulu");
    var input = new ArrayList<>(expected);
    Collections.shuffle(input, random);

    var actual = BasicLambdas.sortByFirstCharacter(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByFirstCharacter_IgnoresCase() {
    var input = List.of("Charlie", "alpha", "echo", "Delta");
    var expected = List.of("alpha", "Charlie", "Delta", "echo");
    var actual = BasicLambdas.sortByFirstCharacter(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByFirstCharacter_SortsNumbersBeforeLetters() {
    var input = List.of("a", "5");
    var expected = List.of("5", "a");
    var actual = BasicLambdas.sortByFirstCharacter(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  /*
    sortByContainsLowercaseE
   */

  @Test
  void test_sortByContainsLowercaseE_ReturnsSameListIfNoEInItems() {
    var input = List.of("d", "f", "g", "q");
    var actual = BasicLambdas.sortByContainsLowercaseE(input);

    assertEquals(input, actual);

    var shuffled = new ArrayList<>(input);
    Collections.shuffle(shuffled, random);

    actual = BasicLambdas.sortByContainsLowercaseE(shuffled);
    assertEquals(shuffled, actual);

    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByContainsLowercaseE_OnlyMovesItemsWithEToBeginningOfList() {
    var input = List.of("apricot", "aardvark", "apple");
    var expected = List.of("apple", "apricot", "aardvark");
    var actual = BasicLambdas.sortByContainsLowercaseE(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  @Test
  void test_sortByContainsLowercaseE_DoesNotThrowExceptionOnEmptyString() {
    var input = List.of("", "", "");
    assertDoesNotThrow(() -> BasicLambdas.sortByLength(input));
  }

  @Test
  void test_sortByContainsLowercaseE_MovesItemsWithEBeforeEmptyString() {
    var input = List.of("", "apple", "book");
    var expected = List.of("apple", "", "book");
    var actual = BasicLambdas.sortByContainsLowercaseE(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_sortByContainsLowercaseE_IgnoresUppercase() {
    var input = List.of("apricot", "aardvark", "apple", "E");
    var expected = List.of("apple", "apricot", "aardvark", "E");
    var actual = BasicLambdas.sortByContainsLowercaseE(input);

    assertEquals(expected, actual);
    assertNotEquals(input, actual);
  }

  /*
    convertToCommaSeparatedStringWithParityIndicator
   */

  @Test
  void test_convertToCommaSeparatedStringWithParityIndicator_ReturnsExpectedResult() {
    var input = List.of(1, 2, 3, 4);
    var expected = "o1,e2,o3,e4";
    var actual = BasicLambdas.convertToCommaSeparatedStringWithParityIndicator(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_convertToCommaSeparatedStringWithParityIndicator_WorksWithNegativeNumbers() {
    var input = List.of(-1, -2, -3, -4);
    var expected = "o-1,e-2,o-3,e-4";
    var actual = BasicLambdas.convertToCommaSeparatedStringWithParityIndicator(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_convertToCommaSeparatedStringWithParityIndicator_ReturnsEmptyStringOnEmptyInputList() {
    var input = new ArrayList<Integer>();
    var expected = "";
    var actual = BasicLambdas.convertToCommaSeparatedStringWithParityIndicator(input);

    assertEquals(expected, actual);
  }
  
  /*
    filterStartsWithLowercaseAAndIs3Letters
   */

  @Test
  void test_filterStartsWithLowercaseAAndIs3Letters_ReturnsEmptyListOnEmptyInput() {
    var expected = new ArrayList<String>();
    var actual = BasicLambdas.filterStartsWithLowercaseAAndIs3Letters(expected);

    assertEquals(expected, actual);
  }

  @Test
  void test_filterStartsWithLowercaseAAndIs3Letters_ReturnsExpectedResult() {
    var input = List.of("apple", "abc", "aa", "a", "bad", "baa", "book");
    var expected = List.of("abc");
    var actual = BasicLambdas.filterStartsWithLowercaseAAndIs3Letters(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_filterStartsWithLowercaseAAndIs3Letters_DoesNotThrowExceptionOnEmptyItems() {
    var input = List.of("", "aaa", "a", "");

    assertDoesNotThrow(() -> BasicLambdas.filterStartsWithLowercaseAAndIs3Letters(input));
  }

  @Test
  void test_filterStartsWithLowercaseAAndIs3Letters_DoesNotCollectUppercaseA() {
    var input = List.of("apple", "abc", "AAA", "Abc", "aa", "a", "bad", "baa", "book");
    var expected = List.of("abc");
    var actual = BasicLambdas.filterStartsWithLowercaseAAndIs3Letters(input);

    assertEquals(expected, actual);
  }
}
