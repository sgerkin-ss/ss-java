package com.ss.sgerkin.day03.filelist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Utility class for recursively walking and listing the contents of a path.
 */
public class FileLister {

  /**
   * Creates a string of a directory given a filepath, with indentation indicating an additional
   * level of structure.
   *
   * @param path a file directory to walk.
   * @return a string separated by line breaks for each item found during the walk, and indentation
   * indicating the level of the item.
   */
  public static String listFiles(String path) {
    try {
      return Files.walk(Paths.get(path))
          .map(p -> {
            var index = p.getNameCount() - 1;
            var name = p.getName(index);
            return "  ".repeat(index) + name;
          })
          .collect(Collectors.joining("\n"));
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }
}
