package com.ss.sgerkin.day02.terminaladd;

import java.util.Arrays;

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

  private double addArgs(String[] args) {
    return Arrays.stream(args)
        .mapToDouble(this::parseArg)
        .sum();
  }

  private double parseArg(String arg) {
    try {
      return Double.parseDouble(arg);
    } catch (NumberFormatException ex) {
      return 0;
    }
  }

  private void printResult(Double result) {
    var msg = String.format("The total is: %f", result);
    System.out.println(msg);
  }
}
