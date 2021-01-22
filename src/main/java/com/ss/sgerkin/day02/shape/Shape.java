package com.ss.sgerkin.day02.shape;

public interface Shape {

  /**
   * Used to calculate the area of the implementing object.
   *
   * @return the area of the implementing object.
   */
  double calculateArea();

  /**
   * Default method to display the area of the Shape.
   */
  default void display() {
    var className = this.getClass().getSimpleName();
    var msg = String.format("The area of this %s is %f", className, calculateArea());
    System.out.println(msg);
  }
}
