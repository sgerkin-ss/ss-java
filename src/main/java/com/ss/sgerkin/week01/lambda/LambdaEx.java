package com.ss.sgerkin.week01.lambda;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for encapsulating some example lambda functions.
 */
public class LambdaEx {

  private final Map<Integer, PerformOperation> operationMap = Map.of(
      1, isOdd(),
      2, isPrime(),
      3, isPalindrome());


  /**
   * Handles test input by calling the appropriate functions and joining the results to a line
   * separated string.
   * <p>
   * Input is expected as line separated instructions with the first line consisting of a single
   * digit indicating the tests to perform. Each subsequent line consists of 2 space separated
   * digits, the first containing an instruction number 1-3 and the second containing a value to act
   * upon.
   * <p>
   * Input is assumed to be in the correct form when given to this method.
   *
   * @param input
   * @return
   */
  public String handleInput(String input) {
    return Arrays.stream(input.split("\n"))
        .skip(1)
        .map(line -> {
          var split = line.split(" ");
          if (split.length != 2) {
            var msg = String.format("Invalid input: %s", line);
            throw new IllegalArgumentException(msg);
          }
          var action = Integer.parseInt(split[0]);
          var value = Integer.parseInt(split[1]);

          return getAction(action)
              .apply(value);
        })
        .collect(Collectors.joining("\n"));
  }

  /**
   * Returns the function for a given instruction number.
   *
   * @param action the action instruction number.
   * @return the function to execute for that instruction.
   */
  public PerformOperation getAction(int action) {
    if (!operationMap.containsKey(action)) {
      var msg = String.format("Unknown action key: %d", action);
      throw new IllegalArgumentException(msg);
    }
    return operationMap.get(action);
  }

  /**
   * Creates a function to check a numbers parity.
   *
   * @return a {@link PerformOperation} to check for parity.
   */
  public PerformOperation isOdd() {
    return num -> num % 2 == 0 ? "EVEN" : "ODD";
  }

  /**
   * Creates a function to check if a number is prime or composite.
   *
   * @return a {@link PerformOperation} to check for primality.
   */
  public PerformOperation isPrime() {
    return num -> {
      if (num < 2) {
        var msg = String.format("Invalid number: %d. Must be greater than 1.", num);
        throw new IllegalArgumentException(msg);
      }

      var prime = IntStream.rangeClosed(2, (int) Math.sqrt(num))
          .parallel()
          .noneMatch(n -> num % n == 0);

      return prime ? "PRIME" : "COMPOSITE";
    };
  }

  /**
   * Creates a function to check if a digit is a palindrome.
   *
   * @return a {@link PerformOperation} function for checking if a digit is a palindrome.
   */
  public PerformOperation isPalindrome() {
    return num -> {
      var sb = new StringBuilder(num.toString());
      var palindrome = sb.toString().equals(sb.reverse().toString());
      return palindrome ? "PALINDROME" : "NOT PALINDROME";
    };
  }

}
