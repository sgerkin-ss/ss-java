package com.ss.sgerkin.day03.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ss.sgerkin.day03.TestUtils;
import org.junit.jupiter.api.Test;

public class ArgumentParserTest {

  static final String TEMP_PATH = TestUtils.TEMP_PATH;

  @Test
  void testInvalidPathThrowsException() {
    assertThrows(RuntimeException.class, () -> ArgumentParser.parseArgs(new String[]{" ", "a"}));
    assertThrows(RuntimeException.class,
                 () -> ArgumentParser.parseArgs(new String[]{"japwoeigjapogijoijaweof", "a"}));
  }

  @Test
  void testInvalidArgLengthThrowsException() {
    assertThrows(RuntimeException.class, () -> ArgumentParser.parseArgs(null));
    assertThrows(RuntimeException.class, () -> ArgumentParser.parseArgs(new String[]{TEMP_PATH}));
  }

  @Test
  void testInvalidCharThrowsException() {
    assertThrows(RuntimeException.class,
                 () -> ArgumentParser.parseArgs(new String[]{TEMP_PATH, "ah"}));
  }
}
