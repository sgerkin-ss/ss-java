package com.ss.sgerkin.day04.deadlock;

/**
 * A Philosopher dining at a table.
 * <p>
 * Each philosopher undergoes a constant process of thinking and eating. Eating requires a fork in
 * each hand. After eating, the philosopher will place each fork back on the table to be shared by
 * another philosopher.
 */
public class Philosopher implements Runnable {

  private final String name;
  private final Fork leftFork;
  private final Fork rightFork;

  /**
   * A philosopher requires a name and a fork on each side of their plate.
   *
   * @param name      the name of the philosopher.
   * @param leftFork  the fork to the left of the plate.
   * @param rightFork the fork to the right of the plate.
   */
  public Philosopher(String name, Fork leftFork, Fork rightFork) {
    this.name = name;
    this.leftFork = leftFork;
    this.rightFork = rightFork;
  }

  /**
   * A philosopher will pause to think between eating their dish and allow other philosophers to
   * eat.
   */
  public void think() {
    System.out.printf("%s is thinking...%n\n", name);
  }

  /**
   * Thinking is hungry work and periodically, the philosopher must eat!
   */
  public void eat() {
    System.out.printf("%s is eating. Om nom nom.\n", name);
  }

  /**
   * To eat, a philosopher must have two forks. This method puts the left fork in their hand if it
   * is available.
   */
  public void pickUpLeftFork() {
    System.out.printf("%s reaches for the left fork.\n", name);
    while (!leftFork.pickUp(this)) {
      System.out.printf("%s is waiting for the left fork.\n", name);
      leftFork.pickUp(this);
    }

    System.out.printf("%s picks up the left fork.\n", name);
  }

  /**
   * To eat, a philosopher must have two forks. This method puts the right fork in their hand if it
   * is available.
   */
  public void pickUpRightFork() {
    System.out.printf("%s reaches for the right fork.\n", name);
    while (!leftFork.pickUp(this)) {
      System.out.printf("%s is waiting for the right fork.\n", name);
      rightFork.pickUp(this);
    }

    System.out.printf("%s picks up the right fork\n", name);
  }

  /**
   * After eating, a philosopher shares their fork with a fellow. This method will put the left fork
   * back on the table if it is currently in their possession.
   */
  public void putDownLeftFork() {
    while (!leftFork.putDown(this)) {
      leftFork.putDown(this);
    }

    System.out.printf("%s puts down the left fork.\n", name);
  }

  /**
   * After eating, a philosopher shares their fork with a fellow. This method will put the right
   * fork back on the table if it is currently in their possession.
   */
  public void putDownRightFork() {
    while (!rightFork.putDown(this)) {
      rightFork.putDown(this);
    }

    System.out.printf("%s puts down the right fork.\n", name);
  }

  /**
   * Executes a dining philosopher workload of thinking and eating.
   * <p>
   * As a philosopher has no other concerns, this method will repeat forever.
   */
  @Override
  public void run() {
    while (true) {
      think();
      pickUpLeftFork();
      pickUpRightFork();
      eat();
      putDownLeftFork();
      putDownRightFork();
    }
  }

  /**
   * Getter.
   *
   * @return the name of this philosopher.
   */
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Philosopher that = (Philosopher) o;

    if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) {
      return false;
    }
    if (leftFork != null ? !leftFork.equals(that.leftFork) : that.leftFork != null) {
      return false;
    }
    return rightFork != null ? rightFork.equals(that.rightFork) : that.rightFork == null;
  }

  @Override
  public int hashCode() {
    int result = getName() != null ? getName().hashCode() : 0;
    result = 31 * result + (leftFork != null ? leftFork.hashCode() : 0);
    result = 31 * result + (rightFork != null ? rightFork.hashCode() : 0);
    return result;
  }
}
