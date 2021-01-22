package com.ss.sgerkin.day03.charcount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Utility class to count the occurrence of a string in a file.
 */
public class FileCharCounter {

  /**
   * Counts the occurrence of a string in a file.
   *
   * @param file   the file to search.
   * @param toFind the string for which to search.
   * @return the occurrences of the string in the file.
   */
  public static long count(File file, String toFind) {
    try (var stream = new FileInputStream(file);
        var scanner = new Scanner(stream)) {

      return scanner.findAll(toFind)
          .parallel()
          .count();

    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

}
