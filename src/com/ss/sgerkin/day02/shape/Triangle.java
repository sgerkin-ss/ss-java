package com.ss.sgerkin.day02.shape;

public class Triangle implements Shape {

  private final double base;
  private final double height;

  public Triangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  @Override
  public double calculateArea() {
    return 0.5 * base * height;
  }

}
