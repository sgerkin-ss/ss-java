package com.ss.sgerkin.week01.lambda;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaEx {

  private final Map<Integer, PerformOperation> operationMap = Map.of(
      1, isOdd(),
      2, isPrime(),
      3, isPalindrome());


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

  public PerformOperation getAction(int action) {
    if (!operationMap.containsKey(action)) {
      var msg = String.format("Unknown action key: %d", action);
      throw new IllegalArgumentException(msg);
    }
    return operationMap.get(action);
  }

  public PerformOperation isOdd() {
    return num -> num % 2 == 0 ? "EVEN" : "ODD";
  }

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

  public PerformOperation isPalindrome() {
    return num -> {
      var sb = new StringBuilder(num.toString());
      var palindrome = sb.toString().equals(sb.reverse().toString());
      return palindrome ? "PALINDROME" : "NOT PALINDROME";
    };
  }

}
