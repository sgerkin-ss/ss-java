package com.ss.sgerkin.day04.producerconsumer;

import java.util.concurrent.Executors;

/**
 * App to demonstrate a synchronized buffer with a producer and consumer.
 * <p>
 * The buffer itself is designed to only hold items while it is not full, and only return items when
 * it is not empty. Producers place items into the buffer and the consumers will process and consume
 * them in the order of insertion.
 */
public class Main {

  private static final int THREADS = 10;

  public static void main(String[] args) throws InterruptedException {
    var buffer = new Buffer(THREADS / 2);

    var threadPool = Executors.newFixedThreadPool(THREADS);

    for (int i = 0; i < THREADS / 2; i++) {
      threadPool.submit(new Producer(buffer));
      threadPool.submit(new Consumer(buffer));
    }
  }
}
