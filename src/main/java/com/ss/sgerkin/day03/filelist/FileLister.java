package com.ss.sgerkin.day03.filelist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for recursively walking and listing the contents of a path.
 */
public class FileLister {

  /**
   * Creates a list of strings all contents from a given path.
   *
   * Directories will be denoted by (D).
   * Files will be denoted by (F).
   *
   * @param path a file directory to walk.
   * @return a list of all items found during the walk.
   */
  public static List<String> listFiles(String path) {
    try {
      return Files.walk(Paths.get(path))
          .map(p -> p.getName(p.getNameCount() - 1).toString()
              + (new File(p.toString()).isDirectory() ? " (D)" : " (F)"))
          .collect(Collectors.toList());
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}
