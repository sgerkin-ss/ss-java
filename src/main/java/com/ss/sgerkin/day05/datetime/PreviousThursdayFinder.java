package com.ss.sgerkin.day05.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Utility Class to find the previous Thursday given a date.
 */
public class PreviousThursdayFinder {

  /**
   * Finds a previous Thursday provided a {@link LocalDate}.
   *
   * @param date the {@link LocalDate} of which to find the previous Thursday.
   * @return the previous Thursday.
   */
  public static LocalDate findPreviousThursday(LocalDate date) {
    if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
      return date.minusDays(7);
    }
    return findPreviousThursday(date.plusDays(1));
  }
}
