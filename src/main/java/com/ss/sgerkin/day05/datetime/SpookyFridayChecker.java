package com.ss.sgerkin.day05.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Utility class to find Spooky Fridays (Friday the 13th).
 */
public class SpookyFridayChecker {

  /**
   * Checks if a given {@link LocalDate} occurs on a Friday the 13th.
   *
   * @param date the {@link LocalDate} to check.
   * @return true if the date is spooky (Friday the 13th).
   */
  public static boolean isFridayThe13th(LocalDate date) {
    return date.getDayOfWeek() == DayOfWeek.FRIDAY && date.getDayOfMonth() == 13;
  }
}
