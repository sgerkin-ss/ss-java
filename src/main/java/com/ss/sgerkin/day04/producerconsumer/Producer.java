package com.ss.sgerkin.day04.producerconsumer;

import java.util.Random;

/**
 * Produces an item to place in a {@link Buffer}.
 */
public class Producer implements Runnable {

  private final Buffer buffer;
  private final Random random = new Random();

  /**
   * Producers require a {@link Buffer} into which to place values.
   *
   * @param buffer a {@link Buffer} into which to place values.
   */
  public Producer(Buffer buffer) {
    this.buffer = buffer;
  }

  /**
   * Produces a value to place into the buffer and prints the value.
   *
   * @throws InterruptedException if an  interruption occurs while waiting on the buffer to receive
   *                              the put.
   */
  public void produce() throws InterruptedException {
    var value = Math.abs(random.nextInt(500));
    System.out.printf("Produce: %d.\n", value);
    buffer.put(value);
  }

  /**
   * Infinitely produces into the buffer.
   * <p>
   * Thread will sleep between calls for a staggered demonstration.
   */
  @Override
  public void run() {
    while (true) {
      try {
        produce();
        Thread.sleep(500L);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }
  }
}
