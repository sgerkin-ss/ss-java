package com.ss.sgerkin.day05.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class to get a list of all {@link LocalDate}s that occur on a Monday.
 */
public class MondayLister {

  /**
   * Returns a list of all {@link LocalDate}s that fall on a Monday for the current year.
   * <p>
   * Current year is determined by <code>LocalDate.now()</code>.
   *
   * @param month the month for which to get Mondays.
   * @return a list of all Mondays for the given month this year.
   */
  public static List<LocalDate> getMondays(Month month) {
    return getMondays(month.getValue());
  }

  /**
   * Returns a list of all {@link LocalDate}s that fall on a Monday for the current year.
   * <p>
   * Current year is determined by <code>LocalDate.now()</code>.
   *
   * @param month the month for which to get mondays (as an integer value 1-12).
   * @return a list of all Mondays for the given month this year.
   * @throws IllegalArgumentException if the given month is not between 1 and 12.
   */
  public static List<LocalDate> getMondays(int month) {
    return getMondays(LocalDate.now().getYear(), month);
  }

  /**
   * Returns a list of all {@link LocalDate}s that fall on a Monday given a specific year.
   * <p>
   * This only works for years between 1900 and 2200 (for safety and accuracy).
   *
   * @param year  a year between 1900 and 2200 (inclusive).
   * @param month the month for which to get mondays (as an integer value 1-12).
   * @return a list of all Mondays for the given month the given year.
   * @throws IllegalArgumentException if year or month is out of range.
   */
  public static List<LocalDate> getMondays(int year, int month) {
    if (year < 1900 || year > 2200) {
      var msg = String.format("Invalid year: %d. Must be between 1900 and 2200", year);
      throw new IllegalArgumentException(msg);
    }
    if (month < 1 || month > 12) {
      var msg = String.format("Invalid month: %d. Must be between 1 and 12.", month);
      throw new IllegalArgumentException(msg);
    }

    var monthStart = LocalDate.of(year, month, 1);

    var monthLength = monthStart.getMonth().length(monthStart.isLeapYear());

    return IntStream.range(0, monthLength)
        .mapToObj(monthStart::plusDays)
        .filter(date -> date.getDayOfWeek().equals(DayOfWeek.MONDAY))
        .collect(Collectors.toList());
  }

}
