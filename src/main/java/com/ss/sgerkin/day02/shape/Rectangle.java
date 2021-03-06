package com.ss.sgerkin.day02.shape;

/**
 * A rectangle object that stores the height and width of the rectangle and can calculate the area.
 */
public class Rectangle implements Shape {

  private final double height;
  private final double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public double calculateArea() {
    return height * width;
  }
}
