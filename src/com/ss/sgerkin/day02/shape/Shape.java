package com.ss.sgerkin.day02.shape;

public interface Shape {

  double calculateArea();

  default void display() {
    var className = this.getClass().getSimpleName();
    var msg = String.format("The area of this %s is %f", className, calculateArea());
    System.out.println(msg);
  }
}
