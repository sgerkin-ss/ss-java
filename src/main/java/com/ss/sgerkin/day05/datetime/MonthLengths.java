package com.ss.sgerkin.day05.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class to get the length of each month in a given year.
 */
public class MonthLengths {

  /**
   * Creates a map of {@link Month}, {@link Integer} pairs with the length of each month.
   *
   * @param year the year for which to get the lengths of each month.
   * @return a {@link Map} as with the key as {@link Month} and value as the length of the month.
   */
  public static Map<Month, Integer> getMonthLengths(int year) {
    var startDate = LocalDate.of(year, 1, 1);
    return IntStream.range(0, 12)
        .mapToObj(startDate::plusMonths)
        .collect(Collectors.toMap(LocalDate::getMonth,
                                  date -> date.getMonth().length(startDate.isLeapYear())));

  }

  public static void main(String[] args) {
    getMonthLengths(2021).forEach((k,v) -> System.out.println(k.toString() + " : " + v));
  }
}
