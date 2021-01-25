package com.ss.sgerkin.day04.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Buffer stores Integer values from a {@link Producer} to be processed by a {@link Consumer}. If
 * the buffer is full, it will wait before inserting new items.
 */
public class Buffer {

  private final int size;
  private final Queue<Integer> buffer = new LinkedList<>();

  /**
   * Buffers are of a fixed size and require that information at instantiation.
   *
   * @param size the size of the buffer.
   */
  public Buffer(int size) {
    this.size = size;
  }

  /**
   * Puts an integer value into the buffer.
   *
   * @param value an integer to store.
   * @throws InterruptedException if the owning thread is interrupted while the buffer is waiting.
   */
  public synchronized void put(int value) throws InterruptedException {
    if (isFull()) {
      System.out.println("Buffer is full. Waiting...");
      wait(1000L);
    }
    buffer.add(value);
    notify();
    System.out.printf("Added %d to buffer.\n", value);
  }

  /**
   * Removes an integer value from the buffer.
   *
   * @return the item at the head of the buffer.
   * @throws InterruptedException if the owning thread is interrupted while the buffer is waiting.
   */
  public synchronized Integer take() throws InterruptedException {
    if (isEmpty()) {
      System.out.println("Buffer is empty. Waiting...");
      wait(1000L);
    }
    var result = buffer.remove();
    notify();
    System.out.printf("Removed %d from buffer.\n", result);
    return result;
  }

  /**
   * Checks to see if the buffer is full.
   *
   * @return true if buffer is full.
   */
  public synchronized boolean isFull() {
    return buffer.size() == size;
  }

  /**
   * Checks to see if the buffer is empty.
   *
   * @return true if the buffer is empty.
   */
  public synchronized boolean isEmpty() {
    return buffer.isEmpty();
  }
}
