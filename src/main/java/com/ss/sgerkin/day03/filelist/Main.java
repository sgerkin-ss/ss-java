package com.ss.sgerkin.day03.filelist;

import java.io.File;

/**
 * Simple app to recursively list the contents of a directory given a directory via the command
 * line.
 */
public class Main {

  /**
   * Driver.
   *
   * @param args an array of execution arguments. Only the first argument is used.
   * @throws IllegalArgumentException if path is not present, not a directory, or cannot be read.
   */
  public static void main(String[] args) {
    if (args.length < 1) {
      throw new IllegalArgumentException("No path given.");
    }
    var path = args[0];
    var file = new File(path);

    if (!file.isDirectory()) {
      throw new IllegalArgumentException("Path is not a directory.");
    }
    if (!file.canRead()) {
      throw new IllegalArgumentException("Path cannot be read.");
    }

    var fileStructure = FileLister.listFiles(path);
    System.out.println(String.join(", ", fileStructure));
  }
}
