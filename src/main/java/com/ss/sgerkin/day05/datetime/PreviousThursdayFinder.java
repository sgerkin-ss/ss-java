package com.ss.sgerkin.day05.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PreviousThursdayFinder {

  public static LocalDate findPreviousThursday(LocalDate date) {
    if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
      return date.minusDays(7);
    }
    return findPreviousThursday(date.plusDays(1));
  }
}
