package com.ss.sgerkin.patternprint;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for printing star and dot patterns.
 */
public class PatternPrinter {

  private final int DOT_START_SIZE = 8;

  /**
   * Main driver for printing the patterns.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    var patternPrinter = new PatternPrinter();
    var pattern = patternPrinter.constructPatterns();
    System.out.println(pattern);
  }

  /**
   * Constructs all patterns as a single String value.
   *
   * @return all the patterns.
   */
  private String constructPatterns() {
    return IntStream
        .rangeClosed(1, 4)
        .mapToObj(this::getPattern)
        .collect(Collectors.joining("\n"));
  }

  /**
   * Gets a pattern for a specific pattern number.
   *
   * @param patternNum the pattern number to get.
   * @return the constructed pattern.
   */
  private String getPattern(int patternNum) {
    var sb = new StringBuilder(patternNum + ")\n");

    var offset = sb.length();

    IntStream.rangeClosed(1, 4)
        .forEach(line -> {
          var starLine = getStarLine(patternNum, line);
          if (reverseStars(patternNum)) {
            sb.insert(offset, starLine);
          } else {
            sb.append(starLine);
          }
        });

    var dots = getDotLine(patternNum) + "\n";
    if (reverseStars(patternNum)) {
      sb.insert(offset, dots);
    } else {
      sb.append(dots);
    }

    return sb.toString();
  }

  /**
   * Gets a line of '*' for the pattern.
   *
   * @param patternNum the pattern number currently being constructed.
   * @param line       the line number for the current star pattern.
   * @return the constructed star line.
   */
  private String getStarLine(int patternNum, int line) {
    var sb = new StringBuilder("*".repeat(line));

    if (shouldIndent(patternNum)) {
      var indentation = " ".repeat(6 - line);
      sb.insert(0, indentation);
      sb.append("*".repeat(line - 1));
    }

    sb.append("\n");
    return sb.toString();
  }

  /**
   * Gets a line of '.' for the pattern.
   *
   * @param patternNum the pattern number currently being constructed.
   * @return the constructed dot line.
   */
  private String getDotLine(int patternNum) {
    return ".".repeat(DOT_START_SIZE + patternNum);
  }

  /**
   * Determines if stars should be reversed in pattern (prepended rather than appended).
   *
   * @param patternNum the pattern number currently being constructed.
   * @return true if stars should be prepended rather than appended.
   */
  private boolean reverseStars(int patternNum) {
    return patternNum % 2 == 0;
  }

  /**
   * Determines if a line of stars should be indented (and repeated).
   *
   * @param patternNum the pattern number currently being constructed.
   * @return true if stars should be indented.
   */
  private boolean shouldIndent(int patternNum) {
    return patternNum >= 3;
  }
}
