package com.ss.sgerkin.patternprint;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PatternPrinter {

  private final int DOT_START_SIZE = 8;

  public static void main(String[] args) {
    var patternPrinter = new PatternPrinter();
    var pattern = patternPrinter.constructPatterns();
    System.out.println(pattern);
  }

  private String constructPatterns() {
    return IntStream
        .rangeClosed(1, 4)
        .mapToObj(this::getPattern)
        .collect(Collectors.joining("\n"));
  }

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

  private String getDotLine(int patternNum) {
    return ".".repeat(DOT_START_SIZE + patternNum);
  }

  private boolean reverseStars(int patternNum) {
    return patternNum % 2 == 0;
  }

  private boolean shouldIndent(int patternNum) {
    return patternNum >= 3;
  }
}
