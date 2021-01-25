package com.ss.sgerkin.day04.deadlock;

/**
 * A Fork is used by a {@link Philosopher} to eat a meal. It can only be possessed by one
 * philosopher at a time.
 */
public class Fork {

  private final int id;
  private Philosopher owner;

  /**
   * Forks must be given an ID to keep track of which fork goes where.
   *
   * @param id the ID of the fork.
   */
  public Fork(int id) {
    this.id = id;
  }

  /**
   * Method to pick up a fork by a philosopher.
   * <p>
   * As a fork can only be in possession by one philosopher at a time, this will return false if it
   * is already in another philosopher's hand.
   *
   * @param pickedUpBy the {@link Philosopher} attempting to pick up the fork.
   * @return true if the {@link Philosopher} was able to pick up the fork.
   */
  public boolean pickUp(Philosopher pickedUpBy) {
    if (owner == null) {
      owner = pickedUpBy;
      return true;
    }

    System.out.printf("Fork %d is already possessed by %s!\n", id, owner.getName());
    return false;
  }

  /**
   * Method to return a fork to the table.
   * <p>
   * Because we may have some metaphysical philosophers that debate what ownership of a fork
   * entails, this method codifies that a fork may only be put down by the owning philosopher. If a
   * philosopher tries to put down a fork not currently in their possession, this will return
   * false.
   *
   * @param putDownBy the {@link Philosopher} that is attempting to put down the fork.
   * @return true if the fork was placed onto the table.
   */
  public boolean putDown(Philosopher putDownBy) {
    if (owner.equals(putDownBy)) {
      owner = null;
      return true;
    }

    System.out.printf("%s cannot put down this fork, it is owned by %s",
                      putDownBy.getName(),
                      owner.getName());
    return false;
  }


}
