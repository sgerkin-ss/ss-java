package com.ss.sgerkin.day05.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Simple utility class to convert between {@link Instant} and {@link ZonedDateTime}.
 */
public class InstantConverter {

  /**
   * Converts an {@link Instant} to {@link ZonedDateTime} using UTC.
   *
   * @param instant the {@link Instant} to convert.
   * @return a {@link ZonedDateTime} at UTC.
   */
  public static ZonedDateTime convertToZdt(Instant instant) {
    return convertToZdt(instant, ZoneId.of("UTC"));
  }

  /**
   * Converts an {@link Instant} to a {@link ZonedDateTime} given a {@link ZoneId}.
   *
   * @param instant the {@link Instant} to convert.
   * @param zoneId  the {@link ZoneId} at which to set the instant.
   * @return a {@link ZonedDateTime} of the instant at the provided zone.
   */
  public static ZonedDateTime convertToZdt(Instant instant, ZoneId zoneId) {
    return instant.atZone(zoneId);
  }
}
