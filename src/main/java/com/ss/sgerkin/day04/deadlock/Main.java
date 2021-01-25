package com.ss.sgerkin.day04.deadlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple application to demonstrate the Dining Philosophers problem that can create a deadlock in a
 * multi-threaded environment.
 * <p>
 * Each Philosopher must share a set of forks for eating, a left fork and a right fork. Without
 * appropriate handling of race conditions, the philosophers can be stuck in a deadlock wherein they
 * are all waiting for a fork to be placed on the table and no philosopher is willing to place their
 * own on the table until they eat.
 */
public class Main {

  private static final List<String> philosopherNames = List.of("Sartre",
                                                               "Descartes",
                                                               "Confucius",
                                                               "Plato",
                                                               "Kant");

  /**
   * Driver for demonstrating the application.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    var forks = new ArrayList<Fork>();
    var philosophers = new ArrayList<Philosopher>();
    for (int i = 1; i < 6; i++) {
      var fork = new Fork(i);
      forks.add(fork);
    }

    for (int i = 0; i < forks.size(); i++) {
      var leftFork = forks.get(i);
      var rightFork = forks.get(i % 5);
      var name = philosopherNames.get(i);
      var philosopher = new Philosopher(name, leftFork, rightFork);
      philosophers.add(philosopher);
    }

    philosophers.forEach(Philosopher::run);
  }


}
