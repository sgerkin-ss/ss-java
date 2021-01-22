package com.ss.sgerkin.day02.terminaladd;

import java.util.Arrays;

/**
 * Application to add a list of arguments given from the command line.
 */
public class TerminalAdder {

  public static void main(String[] args) {
    var terminalAdder = new TerminalAdder();

    if (args.length > 0) {
      var result = terminalAdder.addArgs(args);
      terminalAdder.printResult(result);
    } else {
      System.err.println("No arguments given for addition.");
    }
  }

  /**
   * Adds an array of String arguments representing double values.
   *
   * @param args an array of doubles as String to add.
   * @return the sum of the array.
   */
  private double addArgs(String[] args) {
    return Arrays.stream(args)
        .mapToDouble(this::parseArg)
        .sum();
  }

  /**
   * Parses an individual argument from String to double.
   * <p>
   * Returns 0 if the argument is not a number value.
   *
   * @param arg the arg to parse.
   * @return the value of the argument. 0 if not a number.
   */
  private double parseArg(String arg) {
    try {
      return Double.parseDouble(arg);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  /**
   * Prints the result of the addition to the console.
   *
   * @param result the result to display.
   */
  private void printResult(Double result) {
    var msg = String.format("The total is: %f", result);
    System.out.println(msg);
  }
}
