package com.ss.sgerkin.day02.shape;

/**
 * Demonstration driver for {@link Shape} implementations.
 */
public class Main {

  public static void main(String[] args) {
    var circle = new Circle(5.0);
    circle.display();

    var triangle = new Triangle(3.0, 4.0);
    triangle.display();

    var rectangle = new Rectangle(6.5, 2.5);
    rectangle.display();
  }
}
