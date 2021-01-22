package com.ss.sgerkin.day02.arraymax;

import java.util.Random;

public class ArrayMaxFinder {

  public static void main(String[] args) {
    var finder = new ArrayMaxFinder();
    var demoArr = createDemoArray(20, 20);
    var result = finder.findMax(demoArr);
    System.out.println(result.toString());
  }

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
