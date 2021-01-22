package com.ss.sgerkin.day03.fileappender;

import com.ss.sgerkin.day03.utils.ArgumentParser;
import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Application to append a string to an existing file.
 * <p>
 * Arguments are expected in the form "filepath string...". Any input following the filepath will be
 * appended to the file.
 */
public class Main {

  /**
   * Driver for app.
   *
   * @param args a size 2 array containing a filepath and a string to append to the file.
   */
  public static void main(String[] args) {
    try {
      var path = args[0];
      var toAppend = Arrays.stream(args, 1, args.length)
          .collect(Collectors.joining(" "));

      var commandArguments = ArgumentParser.parseArgs(Objects::nonNull, path, toAppend);

      var file = new File(commandArguments.getFilePath());

      FileAppender.appendToFile(file, toAppend);
    } catch (IndexOutOfBoundsException ex) {
      throw new IllegalArgumentException("No filepath given.");
    } catch (IllegalArgumentException ex) {
      var msg = "An exception occurred while attempting to parse your input.\n" + ex.getMessage();
      throw new RuntimeException(msg);
    }
  }
}
