package com.ss.sgerkin.day03.utils;

import com.ss.sgerkin.day03.charcount.FileCharCounter;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Utility class for parsing command line arguments for {@link FileCharCounter}.
 *
 * @see #parseArgs(Predicate, String...) 
 */
public class ArgumentParser {

  private static final int VALID_ARG_LENGTH = 2;

  /**
   * Parses an array string arguments.
   * <p>
   * Arguments are expected as a length 2 array with the first item containing a readable filepath
   * (relative or absolute) and the second item containing a single character.
   *
   * @param args arguments to parse.
   * @return a {@link CommandArguments} object.
   * @throws IllegalArgumentException if arguments are invalid.
   */
  public static CommandArguments parseArgs(String[] args) {
    return parseArgs( arg -> arg.length() == 1, args);
  }

  /**
   * Parses an array string arguments.
   * <p>
   * Arguments are expected as a length 2 array with the first item containing a readable filepath
   * (relative or absolute). Second argument is tested based on the predicate parameter given.
   *
   * @param args             arguments to parse.
   * @param secondaryArgTest a predicate for testing the second argument of the array.
   * @return a {@link CommandArguments} object.
   * @throws IllegalArgumentException if arguments are invalid.
   */
  public static CommandArguments parseArgs(Predicate<String> secondaryArgTest, String... args) {
    var exceptions = validate(args, secondaryArgTest);

    if (exceptions.size() != 0) {
      var msg = String.join("\n", exceptions);
      throw new IllegalArgumentException(msg);
    }

    return new CommandArguments(args[0], args[1]);
  }

  /**
   * Validates an array of string arguments matches the expected input.
   * <p>
   * The first argument is expected to be a readable file (or path).
   *
   * @param args             the arguments to validate.
   * @param secondaryArgTest a predicate for the secondary argument.
   * @return a list of exceptions if any validations failed. Empty list implies all validations
   * successful.
   */
  private static List<String> validate(String[] args, Predicate<String> secondaryArgTest) {
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

      if (!secondaryArgTest.test(args[1])) {
        var msg = String.format("Invalid secondary argument: '%s'", args[1]);
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

}
