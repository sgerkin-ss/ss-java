package com.ss.sgerkin.day03.charcount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCharCounter {


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
