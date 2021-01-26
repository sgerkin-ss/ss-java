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

  /**
   * Stores the birthday at the beginning of the given date using the system default timezone.
   *
   * @param birthDate a {@link LocalDate} of the birthday.
   */
  public Birthday(LocalDate birthDate) {
    this(birthDate.atStartOfDay());
  }

  /**
   * Stores a birthday and time using the system default timezone.
   *
   * @param birthDate a {@link LocalDateTime} of the birthday.
   */
  public Birthday(LocalDateTime birthDate) {
    this(birthDate.atZone(ZoneId.systemDefault()));
  }

  /**
   * Stores a birthday and time with a provided timezone.
   *
   * @param birthDate a {@link ZonedDateTime} of the birthday.
   */
  public Birthday(ZonedDateTime birthDate) {
    this(birthDate.toInstant());
  }

  /**
   * Stores a birthday at an exact instant.
   *
   * @param birthday a {@link Instant} of the birthday.
   */
  public Birthday(Instant birthday) {
    this.birthday = birthday;
  }

  /**
   * Getter.
   *
   * @return the {@link #birthday} stored.
   */
  public Instant getBirthday() {
    return birthday;
  }

  public String toString() {
    return birthday.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Birthday birthday1 = (Birthday) o;

    return getBirthday() != null ? getBirthday().equals(birthday1.getBirthday())
        : birthday1.getBirthday() == null;
  }

  @Override
  public int hashCode() {
    return getBirthday() != null ? getBirthday().hashCode() : 0;
  }
}
