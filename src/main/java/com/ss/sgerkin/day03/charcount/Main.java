package com.ss.sgerkin.day03.charcount;

import com.ss.sgerkin.day03.utils.ArgumentParser;
import java.io.File;

/**
 * Application to count the occurrences of a character in a file given arguments from the command
 * line.
 * <p>
 * Arguments are expected in the form "filepath character". Filepath can be absolute or relative.
 * Character argument is expected to be a single character (ie "a" but not "ah").
 * <p>
 * Example usage:
 * <code>java -jar jarname.jar path/to/file e</code>
 */
public class Main {

  /**
   * Driver for app.
   *
   * @param args a size 2 array containing filepath and a character to count (in that order).
   */
  public static void main(String[] args) {
    try {
      var commandArguments = ArgumentParser.parseArgs(args);

      var file = new File(commandArguments.getFilePath());
      var chToFind = commandArguments.getStringToUse();

      var count = FileCharCounter.count(file, chToFind);

      printCount(chToFind, count);
    } catch (IllegalArgumentException ex) {
      var msg = "An exception occurred while attempting to parse your input.\n" + ex.getMessage();
      throw new RuntimeException(msg);
    }
  }

  /**
   * Prints the count of a character in the file.
   *
   * @param ch    the character counted.
   * @param count the number of occurrences.
   */
  private static void printCount(String ch, long count) {
    var verb = count > 1 ? "were" : "was";
    var noun = "occurrence" + (count > 1 ? "s" : "");
    var msg = String.format("There %s %d %s of '%s'", verb, count, noun, ch);
    System.out.println(msg);
  }
}
