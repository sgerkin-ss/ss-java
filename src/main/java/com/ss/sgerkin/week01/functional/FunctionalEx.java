package com.ss.sgerkin.week01.functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalEx {

  public List<Integer> getRightMostDigit(List<Integer> list) {
    return list.stream()
        .map(i -> i % 10)
        .collect(Collectors.toList());
  }

  public List<Integer> getMultipliedByTwo(List<Integer> list) {
    return list.stream()
        .map(i -> i * 2)
        .collect(Collectors.toList());
  }

  public List<String> removeX(List<String> list) {
    return list.stream()
        .map(item -> item.replaceAll("x", ""))
        .collect(Collectors.toList());
  }
}
