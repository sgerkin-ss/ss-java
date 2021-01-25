package com.ss.sgerkin.day04.line;

public class Line {

  private final double x0;
  private final double y0;
  private final double x1;
  private final double y1;

  public Line(double x0, double y0, double x1, double y1) {
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
  }

  public double getSlope() {
    if (x1 == x0) {
      throw new ArithmeticException();
    }

    return (y1 - y0) / (x1 - x0);
  }

  public double getDistance() {
    return Math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0));
  }

  public boolean isParallel(Line other) {
    return this.getSlope() == other.getSlope();
  }
}
