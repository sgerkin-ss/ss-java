package com.ss.sgerkin.day04.singleton;

public class Singleton {

  private static volatile Singleton INSTANCE;

  private Singleton() {
  }

  public static Singleton getInstance() {
    if (INSTANCE == null) {
      synchronized (Singleton.class) {
        if (INSTANCE == null) {
          INSTANCE = new Singleton();
        }
      }
    }
    return INSTANCE;
  }

  public void doSomething() {
    System.out.println("Doing something.");
  }
}
