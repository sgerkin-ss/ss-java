package com.ss.sgerkin.day04.producerconsumer;

/**
 * Consumes an item from a {@link Buffer}.
 */
public class Consumer implements Runnable {

  private final Buffer buffer;

  /**
   * Consumers require a {@link Buffer} from which to consume.
   *
   * @param buffer a {@link Buffer} from which to consume.
   */
  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }

  /**
   * Gets a value from the buffer and prints it to the console.
   *
   * @throws InterruptedException if an interruption occurs while waiting on the buffer to return a
   *                              value.
   */
  public void consume() throws InterruptedException {
    var consumed = buffer.take();
    System.out.printf("Consume: %d.\n", consumed);
  }

  /**
   * Infinitely polls the buffer for consumption.
   * <p>
   * Thread will sleep between calls for a staggered demonstration.
   */
  @Override
  public void run() {
    while (true) {
      try {
        consume();
        Thread.sleep(750L);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }

  }
}
