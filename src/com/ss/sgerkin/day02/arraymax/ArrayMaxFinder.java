package com.ss.sgerkin.day02.arraymax;

import java.util.Random;

/**
 * Class to find the maximum value and indices of a 2D array.
 */
public class ArrayMaxFinder {

  /**
   * Demonstration driver.
   *
   * @param args Unused.
   */
  public static void main(String[] args) {
    var finder = new ArrayMaxFinder();
    var demoArr = createDemoArray(20, 20);
    var result = finder.findMax(demoArr);
    System.out.println(result.toString());
  }

  /**
   * Helper function to create a demonstration array.
   *
   * @param sizeX Size of the outer array.
   * @param sizeY Size of the inner array(s).
   * @return a 2D array of random integer values.
   */
  private static int[][] createDemoArray(int sizeX, int sizeY) {
    var random = new Random();

    var arr = new int[sizeX][];

    for (int x = 0; x < sizeX; x++) {
      var subArr = new int[sizeY];
      for (int y = 0; y < sizeY; y++) {
        subArr[y] = random.nextInt();
      }
      arr[x] = subArr;
    }

    return arr;
  }

  /**
   * Finds the maximum integer value of a 2D array and the row/col indices.
   *
   * @param arr the array to search.
   * @return a {@link MaxResult} object containing the result.
   */
  public MaxResult findMax(int[][] arr) {
    var max = Integer.MIN_VALUE;
    var rowIndex = -1;
    var colIndex = -1;

    for (int x = 0; x < arr.length; x++) {
      for (int y = 0; y < arr[x].length; y++) {
        if (arr[x][y] > max) {
          max = arr[x][y];
          rowIndex = x;
          colIndex = y;
        }
      }
    }

    return new MaxResult(max, rowIndex, colIndex);
  }

  /**
   * Utility helper class that stores a value and the indices of the value in a 2D array.
   */
  public static class MaxResult {

    final int value;
    final int rowIndex;
    final int colIndex;

    public MaxResult(int value, int rowIndex, int colIndex) {
      this.value = value;
      this.rowIndex = rowIndex;
      this.colIndex = colIndex;
    }

    @Override
    public String toString() {
      return String.format("Max value: %d located at row %d column %d",
                           value,
                           rowIndex,
                           colIndex);
    }
  }
}
