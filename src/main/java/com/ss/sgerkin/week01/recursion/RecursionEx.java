package com.ss.sgerkin.week01.recursion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of ints, is it possible to choose a group of some of the ints, such that the group
 * sums to the given target, with this additional constraint: if there are numbers in the array that
 * are adjacent and the identical value, they must either all be chosen, or none of them chosen.
 */
public class RecursionEx {

  /**
   * Checks a list of integers to see if a group of items from the list can be summed to a given
   * target.
   * <p>
   * Constraint: If the list contains a run of consecutive same numbers, all the numbers from this
   * run must be used to check for summation. No other summation is valid.
   *
   * @param list   a list of integers to check.
   * @param target the target we want to find from the list item summations.
   * @return true if the list contains a group of integers that can be summed up to the target and
   * matches the constraints.
   */
  public boolean groupSumClump(List<Integer> list, int target) {
    if (isRun(list) && listSumEqualsTarget(list, target)) {
      return true;
    }

    if (containsRun(list)) {
      var run = findRun(list);
      return listSumEqualsTarget(run, target);
    }

    return subsetSumsToTarget(list, target, 0);
  }

  /**
   * Helper function for determining if a subset of a list can be summed to the target.
   * <p>
   * Calls recursively with a partial summation and removes the first item from the list each time.
   * If the current partial sum or the partial sum plus the first item from the list sums up to the
   * target, then a subset of values from the list can be summed up to the target.
   * <p>
   * Initial calls to this should set the partial parameter to 0.
   *
   * @param list    a list of integer values not containing a run of duplicates that is to be
   *                checked for summation to the target.
   * @param target  the target we want to find from the list subset summation
   * @param partial a helper parameter for keeping track of recurrent calls. Initial call should be
   *                set to 0.
   * @return true if a subset of the list can be summed to the target.
   */
  private boolean subsetSumsToTarget(List<Integer> list, int target, int partial) {
    if (partial == target) {
      return true;
    }
    if (list.isEmpty()) {
      return false;
    }

    var removeFirst = list.stream()
        .skip(1)
        .collect(Collectors.toList());

    return subsetSumsToTarget(removeFirst, target, partial)
        || subsetSumsToTarget(removeFirst, target, partial + list.get(0));

  }

  /**
   * Checks if a given list consists of a single, distinct integer value (is a run of integers).
   *
   * @param list the list to check.
   * @return true if the list contains only 1 distinct integer value.
   */
  public boolean isRun(List<Integer> list) {
    var distinct = list.stream()
        .distinct()
        .count();
    return distinct == 1;
  }

  /**
   * Checks to see if an entire list of integers sums to a given target.
   *
   * @param list   the list to check.
   * @param target the sum to check.
   * @return true if the list sums to the target.
   */
  public boolean listSumEqualsTarget(List<Integer> list, int target) {
    return list.stream()
        .mapToInt(i -> i)
        .sum() == target;
  }

  /**
   * Checks a list to see if there is a consecutive run of same valued integers.
   *
   * @param list the list to check.
   * @return true if a run exists in the list.
   */
  public boolean containsRun(List<Integer> list) {
    return IntStream.range(1, list.size())
        .anyMatch(i -> list.get(i).equals(list.get(i - 1)));
  }

  /**
   * Finds the first run in a list and returns a new list of the run.
   * <p>
   * This method assumes there is only one run AND that a run exists. This should be verified with
   * {@link #containsRun(List)} prior to using this method.
   * <p>
   * For example, given {1, 2, 2, 3}, this will return {2, 2}.
   * <p>
   * As a note: the implementation appears at first glace to be O(N^2), but in fact it is O(N).
   * There are 2 iterations of the given list, but they are not nested.
   * <p>
   * TODO: Consider returning an empty list if no run to remove exceptions.
   *
   * @param list the list to search.
   * @return a list of the run.
   * @throws IllegalArgumentException if the list does not contain a run.
   */
  public List<Integer> findRun(List<Integer> list) {
    return IntStream.range(1, list.size())
        .filter(i -> list.get(i).equals(list.get(i - 1)))
        .boxed()
        .findFirst()
        // `runIndex  - 1` to start at beginning of run instead of second item
        .map(runIndex -> IntStream.range(runIndex - 1, list.size())
            .takeWhile(i -> list.get(i).equals(list.get(runIndex)))
            .mapToObj(list::get)
            .collect(Collectors.toList()))
        .orElseThrow(() -> new IllegalArgumentException("List does not contain run"));
  }
}
