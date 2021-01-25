package com.ss.sgerkin.day04.producerconsumer;

public class Consumer implements Runnable {

  private final Buffer buffer;

  public Consumer(Buffer buffer) {
    this.buffer = buffer;
  }

  public void consume() throws InterruptedException {
    var consumed = buffer.take();
    System.out.printf("Consume: %d.\n", consumed);
    Thread.sleep(750L);
  }

  @Override
  public void run() {
    while (true) {
      try {
        consume();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);
      }
    }

  }
}
