package com.ss.sgerkin.day03.charcount;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing command line arguments for {@link FileCharCounter}.
 *
 * @see #parseArgs(String[])
 */
public class ArgumentParser {

  private static final int VALID_ARG_LENGTH = 2;

  /**
   * Parses an array of string arguments.
   * <p>
   * Arguments are expected as a length 2 array with the first item containing a readable filepath
   * (relative or absolute) and the second item containing a single character.
   *
   * @param args arguments to parse.
   * @return a {@link CommandArguments} object.
   * @throws IllegalArgumentException if arguments are invalid.
   */
  public static CommandArguments parseArgs(String[] args) {
    var exceptions = validate(args);

    if (exceptions.size() != 0) {
      var msg = String.join("\n", exceptions);
      throw new IllegalArgumentException(msg);
    }

    var filePath = args[0];
    var toFind = args[1].charAt(0);

    return new CommandArguments(filePath, toFind);
  }

  private static List<String> validate(String[] args) {
    var exceptions = new ArrayList<String>();

    if (!validNumberOfArgs(args)) {
      var msg = String.format("Invalid number of arguments. Expected: %d\tReceived: %d",
                              VALID_ARG_LENGTH,
                              args.length);
      exceptions.add(msg);
    } else {
      if (!filePathIsReadable(args[0])) {
        var msg = String.format("Unable to read file: '%s'", args[0]);
        exceptions.add(msg);
      }

      if (!secondArgumentIsCharacter(args[1])) {
        var msg = String.format("Invalid character argument: '%s'", args[1]);
        exceptions.add(msg);
      }
    }

    return exceptions;
  }

  private static boolean validNumberOfArgs(String[] args) {
    return args.length == VALID_ARG_LENGTH;
  }

  private static boolean filePathIsReadable(String filePath) {
    return Files.isReadable(new File(filePath).toPath());
  }

  private static boolean secondArgumentIsCharacter(String arg) {
    return arg.length() == 1;
  }

}
