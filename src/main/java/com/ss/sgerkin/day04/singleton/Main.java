package com.ss.sgerkin.day04.singleton;

public class Main {

  public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance();
    singleton.doSomething();
  }

}
