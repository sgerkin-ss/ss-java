package com.ss.sgerkin.day05.lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Day  05 - Basic Lambda and Streams assignment.
 */
public class BasicLambdas {

  /**
   * Sorts a list of strings by the length where shorter strings are before longer.
   *
   * @param list a list of strings to sort.
   * @return a new sorted list.
   */
  public static List<String> sortByLength(List<String> list) {
    return list.stream()
        .sorted(Comparator.comparingInt(String::length))
        .collect(Collectors.toList());
  }

  /**
   * Sorts a list of strings by length where longer strings are before shorter.
   *
   * @param list a list of strings to sort.
   * @return a new sorted list.
   */
  public static List<String> shortByLengthReversed(List<String> list) {
    return list.stream()
        .sorted(Comparator.comparingInt(item -> item.length() * -1))
        .collect(Collectors.toList());
  }

  /**
   * Sorts a list of strings by the character at index 0 (case insensitive).
   * <p>
   * This is sorted by ASCII ordering, ie "1" is before "a". For letter ordering, this is case
   * insensitive and will treat "a" the same as "A".
   *
   * @param list a list of strings to sort.
   * @return a new sorted list.
   */
  public static List<String> sortByFirstCharacter(List<String> list) {
    return list.stream()
        .sorted(Comparator
                    .comparing(str -> str.isEmpty() ? ""
                        : String.valueOf(str.charAt(0)).toLowerCase()))
        .collect(Collectors.toList());
  }

  /**
   * Sorts a list by placing items that contain the letter "e" (case sensitive) before those
   * without.
   * <p>
   * All other ordering is maintained by the sort.
   *
   * @param list a list of strings to sort.
   * @return a new sorted list.
   */
  public static List<String> sortByContainsLowercaseE(List<String> list) {
    return list.stream()
        // if it doesn't contain 'e', it is "bigger" than if it does and comes after
        .sorted(Comparator.comparing(item -> !item.contains("e")))
        .collect(Collectors.toList());
  }

  /**
   * Converts a list of integer values to a comma separated string, prepended with a parity
   * indicator.
   * <p>
   * Odd numbers will have "o" prepended, ie "o1". Even numbers will have "e" prepended, ie "e2".
   * <p>
   * Parity is determined by <code>num % 2 == 0</code> (meaning 0 is even).
   *
   * @param list a list of integers to convert and concat.
   * @return a comma separated string of the input with parity indicators.
   */
  public static String convertToCommaSeparatedStringWithParityIndicator(List<Integer> list) {
    return list.stream()
        .map(item -> (item % 2 == 0 ? "e" : "o") + item)
        .collect(Collectors.joining(","));
  }

  /**
   * Filters a list of strings by those that start with "a" (case sensitive) and are exactly length
   * of 3.
   *
   * @param list a list of strings to filter.
   * @return a new filtered list.
   */
  public static List<String> filterStartsWithLowercaseAAndIs3Letters(List<String> list) {
    return list.stream()
        .filter(item -> item.startsWith("a"))
        .filter(item -> item.length() == 3)
        .collect(Collectors.toList());
  }
}
