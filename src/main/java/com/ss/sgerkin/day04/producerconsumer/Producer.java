package com.ss.sgerkin.day04.producerconsumer;

import java.util.Random;

public class Producer implements Runnable {

  private final Buffer buffer;
  private final Random random = new Random();

  public Producer(Buffer buffer) {
    this.buffer = buffer;
  }

  public void produce() throws InterruptedException {
    var value = Math.abs(random.nextInt(500));
    System.out.printf("Produce: %d.\n", value);
    buffer.put(value);
  }

  @Override
  public void run() {
    while (true) {
      try {
        produce();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }
  }
}
