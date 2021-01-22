package com.ss.sgerkin.day03.fileappender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class to append text to a file.
 */
public class FileAppender {

  /**
   * Appends text to the end of an existing file.
   *
   * @param file the file to append.
   * @param text the text to append.
   * @throws RuntimeException if an IOException occurs.
   */
  public static void appendToFile(File file, String text) {
    try (var writer = new FileWriter(file, true)) {
      writer.write(text);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}
