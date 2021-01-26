package com.ss.sgerkin.day05.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Class to store a Birthday to nanosecond precision.
 */
public class Birthday {

  private final Instant birthday;

  public Birthday(LocalDate birthDate) {
    this(birthDate.atStartOfDay());
  }

  public Birthday(LocalDateTime birthDate) {
    this(birthDate.atZone(ZoneId.systemDefault()));
  }

  public Birthday(ZonedDateTime birthDate) {
    this(birthDate.toInstant());
  }

  public Birthday(Instant birthday) {
    this.birthday = birthday;
  }

  public Instant getBirthday() {
    return birthday;
  }

  public String toString() {
    return birthday.toString();
  }
}
