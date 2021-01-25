package com.ss.sgerkin.day04.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

  private final int size;
  private final Queue<Integer> buffer = new LinkedList<>();

  public Buffer(int size) {
    this.size = size;
  }

  public synchronized void put(int value) throws InterruptedException {
    if (isFull()) {
      wait(1000L);
    }
    buffer.add(value);
    notify();
    System.out.printf("Added %d to buffer.\n", value);
  }

  public synchronized Integer take() throws InterruptedException {
    if (isEmpty()) {
      wait(1000L);
    }
    var result = buffer.remove();
    notify();
    System.out.printf("Removed %d from buffer.\n", result);
    return result;
  }

  public synchronized boolean isFull() {
    return buffer.size() == size;
  }

  public synchronized boolean isEmpty() {
    return buffer.isEmpty();
  }
}
