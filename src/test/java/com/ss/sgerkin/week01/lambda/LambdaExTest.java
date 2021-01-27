package com.ss.sgerkin.week01.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LambdaExTest {

  private static final LambdaEx lambdaEx = new LambdaEx();
  private static final Integer[] firstHundredPrimes = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23,
      29, 31,
      37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
      137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233,
      239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
      353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461,
      463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};

  @Test
  void test_handleInput_GivenExampleInputReturnsCorrectResult() {
    var input = "5\n"
        + "1 4\n"
        + "2 5\n"
        + "3 898\n"
        + "1 3\n"
        + "2 12";

    var expected = "EVEN\n"
        + "PRIME\n"
        + "PALINDROME\n"
        + "ODD\n"
        + "COMPOSITE";

    var actual = lambdaEx.handleInput(input);

    assertEquals(expected, actual);
  }

  /*
    getAction
   */

  @Test
  void test_getAction_ThrowsExceptionOnInvalidAction() {
    assertThrows(IllegalArgumentException.class, () -> lambdaEx.getAction(0));
    assertThrows(IllegalArgumentException.class, () -> lambdaEx.getAction(4));
  }

  @Test
  void test_getAction_GetsIsOddForAction1() {
    var input = 1;
    var expected = lambdaEx.isOdd();
    var actual = lambdaEx.getAction(input);

    assertEquals(expected, actual);
  }

  /*
    isOdd
   */

  @Test
  void test_getAction_GetsIsPrimeForAction2() {
    var input = 2;
    var expected = lambdaEx.isPrime();
    var actual = lambdaEx.getAction(input);

    assertEquals(expected, actual);
  }

  @Test
  void test_getAction_GetsIsPalindromeForAction3() {
    var input = 3;
    var expected = lambdaEx.isPalindrome();
    var actual = lambdaEx.getAction(input);

    assertEquals(expected, actual);
  }

  /*
    isPrime
   */

  @Test
  void test_isOdd_ReturnsCorrectValueForOddNumbers() {
    var expected = "ODD";

    IntStream.iterate(1, i -> i + 2)
        .limit(10_000)
        .parallel()
        .forEach(i -> assertEquals(expected, lambdaEx.isOdd().apply(i)));
  }

  @Test
  void test_isOdd_ReturnsCorrectValueForEvenNumbers() {
    var expected = "EVEN";

    IntStream.iterate(0, i -> i + 2)
        .limit(10_000)
        .parallel()
        .forEach(i -> assertEquals(expected, lambdaEx.isOdd().apply(i)));
  }

  @Test
  void test_isPrime_ThrowsExceptionForNumberLessThan2() {
    assertThrows(IllegalArgumentException.class, () -> lambdaEx.isPrime().apply(1));
    assertThrows(IllegalArgumentException.class, () -> lambdaEx.isPrime().apply(0));
    assertThrows(IllegalArgumentException.class, () -> lambdaEx.isPrime().apply(-1));
  }

  @Test
  void test_isPrime_ReturnsCorrectValueForPrimeNumbers() {
    var expected = "PRIME";

    Arrays.stream(firstHundredPrimes)
        .forEach(prime -> assertEquals(expected, lambdaEx.isPrime().apply(prime)));
  }

  @Test
  void test_isPrime_ReturnsCorrectValueForCompositeNumbers() {
    var expected = "COMPOSITE";

    var primesAsSet = Set.of(firstHundredPrimes);

    IntStream.range(2, 542)
        .filter(i -> !primesAsSet.contains(i))
        .forEach(i -> assertEquals(expected, lambdaEx.isPrime().apply(i)));
  }

  /*
    isPalindrome
   */

  @Test
  void test_isPalindrome_ReturnsCorrectResultForSingleDigit() {
    var expected = "PALINDROME";

    IntStream.rangeClosed(0, 9)
        .forEach(i -> assertEquals(expected, lambdaEx.isPalindrome().apply(i)));
  }

  @Test
  void test_isPalindrome_ReturnsCorrectResultForDoubleDigit() {
    var expected = "PALINDROME";

    IntStream.iterate(11, i -> i + 11)
        .limit(9)
        .forEach(i -> assertEquals(expected, lambdaEx.isPalindrome().apply(i)));
  }

  @Test
  void test_isPalindrome_ReturnsCorrectResultForNonPalindromeDoubleDigit() {
    var expected = "NOT PALINDROME";

    IntStream.rangeClosed(10, 99)
        .filter(i -> i % 11 != 0)
        .forEach(i -> assertEquals(expected, lambdaEx.isPalindrome().apply(i)));
  }

  @Test
  void test_isPalindrome_RturnsNotPalindromeForNegativeNumbers() {
    var expected = "NOT PALINDROME";

    IntStream.iterate(-1, i -> i - 1)
        .limit(10)
        .forEach(i -> assertEquals(expected, lambdaEx.isPalindrome().apply(i)));
  }

  @Test
  void test_isPalindrome_ReturnsCorrectResultFor3DigitNumbers() {
    var palindromeInput = List.of(
        121, 252, 393, 555, 414, 676
    );
    var palindromeExpected = "PALINDROME";
    palindromeInput.forEach(i -> assertEquals(palindromeExpected,
                                              lambdaEx.isPalindrome().apply(i)));

    var notPalindromeInput = List.of(
        123, 321, 498, 124, 978, 553
    );
    var notPalindromeExpected = "NOT PALINDROME";
    notPalindromeInput.forEach(i -> assertEquals(notPalindromeExpected,
                                                 lambdaEx.isPalindrome().apply(i)));


  }
}