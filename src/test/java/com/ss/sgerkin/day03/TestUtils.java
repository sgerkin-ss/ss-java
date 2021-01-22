package com.ss.sgerkin.day03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Test utility class to create and delete a temporary file.
 */
public class TestUtils {

  public static final String TEMP_PATH = "/temp/test.txt";
  public static final String FILE_TEXT = "The quick red fox jumped over the lazy brown dog.";

  public static void writeFile() {
    var file = new File(TEMP_PATH);
    try (var writer = new FileWriter(file)) {
      writer.write(FILE_TEXT);
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  public static void deleteFile() {
    var file = new File(TEMP_PATH);
    file.delete();
  }
}
