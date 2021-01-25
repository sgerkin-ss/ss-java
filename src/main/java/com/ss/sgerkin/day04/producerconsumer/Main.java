package com.ss.sgerkin.day04.producerconsumer;

import java.util.concurrent.Executors;

public class Main {

  private static final int THREADS = 2;

  public static void main(String[] args) throws InterruptedException {
    var buffer = new Buffer(THREADS / 2);

    var threadPool = Executors.newFixedThreadPool(THREADS);

    for (int i = 0; i < THREADS / 2; i++) {
      threadPool.submit(new Producer(buffer));
      threadPool.submit(new Consumer(buffer));
    }
  }
}
