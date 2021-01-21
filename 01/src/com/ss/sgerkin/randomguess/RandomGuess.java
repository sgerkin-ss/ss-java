package com.ss.sgerkin.randomguess;

import java.util.Random;
import java.util.Scanner;

/**
 * A Guessing Game that will get input from the user and check against the acceptable range while
 * guesses are still allowed and print an applicable message to the user based on success or failure
 * to guess correctly.
 *
 * @author Stephen Gerkin
 */
public class RandomGuess {

  private static final Scanner scanner = new Scanner(System.in);

  private final int MAX_GUESSES = 5;
  private final int NUM_TO_GUESS = new Random().nextInt(100) + 1;

  private int totalGuesses = 0;

  /**
   * Driver for instantiation and running the game.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    var randomGuess = new RandomGuess();
    randomGuess.playGuessingGame();
  }

  /**
   * Main driver for starting and running the guessing game.
   */
  public void playGuessingGame() {
    printIntroMsg();

    while (totalGuesses < MAX_GUESSES) {
      var guess = getGuess();
      if (guessInRange(guess)) {
        printSuccessMsg();
        return;
      } else {
        printWrongGuessMsg();
      }
    }
    printFailureMsg();
  }

  /**
   * Gets a guess from the user.
   *
   * @return the value entered by the user as a guess.
   */
  private int getGuess() {
    if (totalGuesses > MAX_GUESSES) {
      throw new IllegalStateException("Maximum number of guesses reached.");
    }

    printGuessMsg();
    return parseGuessInput();
  }

  /**
   * Gets and parses user input from the console for a guess.
   *
   * @return the guess input by the user.
   */
  private int parseGuessInput() {
    var input = scanner.nextLine();

    if (input.toLowerCase().contains("q")) {
      System.exit(1);
    }

    try {
      var guess = Integer.parseInt(input);
      totalGuesses++;
      return guess;
    } catch (NumberFormatException ex) {
      printInvalidInputMsg();
      return parseGuessInput();
    }
  }

  /**
   * Checks if a given guess is within the acceptable range.
   * <p>
   * Acceptable range is defined as +/- 10 from {@link #NUM_TO_GUESS}.
   *
   * @param guess the guess to check.
   * @return true if within range.
   */
  private boolean guessInRange(int guess) {
    return guess >= NUM_TO_GUESS - 10 && guess <= NUM_TO_GUESS + 10;
  }

  /**
   * Prints an intro message to the user telling them how to play.
   */
  private void printIntroMsg() {
    var msg = "Welcome to the Guessing Game.\n"
        + "A number has been chosen at random.\n"
        + "It is up to you to guess within range of the number to win!\n"
        + "Good Luck!\n";
    System.out.println(msg);
  }

  /**
   * Prints a prompt for entering a guess to the console.
   */
  private void printGuessMsg() {
    var guessesLeft = MAX_GUESSES - totalGuesses;
    var msg = String.format("You have %d guesses left.\n"
                                + "Enter your next guess (or 'q' to quit).\n"
                                + ">> ", guessesLeft);
    System.out.print(msg);
  }

  /**
   * Prints an alert on invalid input.
   */
  private void printInvalidInputMsg() {
    var msg = "\n"
        + "Invalid Input!\n"
        + "Please enter only an integer value (or 'q' to quit).\n";
    System.out.println(msg);
    printGuessMsg();
  }

  /**
   * Prints a message informing the user their guess was not in range.
   */
  private void printWrongGuessMsg() {
    var msg = "Sorry, that was not quote close enough. Try again!\n";
    System.out.println(msg);
  }

  /**
   * Prints a success message to the console.
   */
  private void printSuccessMsg() {
    var msg = String.format("That guess is within range. You win!"
                                + "\nThe number was %d.", NUM_TO_GUESS);
    System.out.println(msg);
  }

  /**
   * Prints a failure message to the console.
   */
  private void printFailureMsg() {
    var msg = String.format("Sorry, you've run out of guesses."
                                + "\nThe correct number was: %d", NUM_TO_GUESS);
    System.err.println(msg);
  }
}
