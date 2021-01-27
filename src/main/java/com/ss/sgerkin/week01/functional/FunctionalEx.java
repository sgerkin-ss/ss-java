package com.ss.sgerkin.week01.functional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for encapsulating some example functional, streaming methods.
 */
public class FunctionalEx {

  /**
   * Creates a new list of the right most digits from each item in the input list.
   *
   * @param list a list of integers from which to get the right most digit.
   * @return a new list of integers consisting of only the right most digit from the input.
   */
  public List<Integer> getRightMostDigit(List<Integer> list) {
    return list.stream()
        .map(i -> i % 10)
        .collect(Collectors.toList());
  }

  /**
   * Creates a new list of integers multiplied by 2 from the input list.
   *
   * @param list a list of integers to multiply by 2.
   * @return a new list of integers consisting of each input item multiplied by 2.
   */
  public List<Integer> getMultipliedByTwo(List<Integer> list) {
    return list.stream()
        .map(i -> i * 2)
        .collect(Collectors.toList());
  }

  /**
   * Creates a new list from the input with each item having a lowercase 'x' removed.
   *
   * @param list a list of strings from which to remove a lowercase 'x'.
   * @return a new list of strings from the input with lowercase 'x' removed from each.
   */
  public List<String> removeX(List<String> list) {
    return list.stream()
        .map(item -> item.replaceAll("x", ""))
        .collect(Collectors.toList());
  }
}
