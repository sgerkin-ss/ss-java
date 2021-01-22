package com.ss.sgerkin.day02.shape;

/**
 * A circle object that stores the radius of the circle and can calculate the area.
 */
public class Circle implements Shape {

  private final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  public double calculateArea() {
    return Math.PI * Math.pow(radius, 2);
  }
}
