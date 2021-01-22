package com.ss.sgerkin.day03.fileappender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ss.sgerkin.day03.TestUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {

  static final String TEMP_PATH = TestUtils.TEMP_PATH;
  static final String FILE_TEXT = TestUtils.FILE_TEXT;

  @BeforeEach
  void beforeEach() {
    TestUtils.writeFile();
  }

  @AfterEach
  void afterEach() {
    TestUtils.deleteFile();
  }

  @Test
  void testTextIsAppendedToFile() {
    var toAppend = "\nI'm a little teapot, short and stout.";
    var expected = FILE_TEXT + toAppend;

    var split = toAppend.split(" ");
    var args = new String[1 + split.length];
    args[0] = TEMP_PATH;
    System.arraycopy(split, 0, args, 1, args.length - 1);

    Main.main(args);

    String actual;
    try {
      actual = Files.readString(Path.of(TEMP_PATH));
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }

    assertEquals(expected, actual);
  }

  @Test
  void testNoArgumentsThrowsRuntimeException() {
    assertThrows(RuntimeException.class, () -> Main.main(new String[]{}));
  }

  @Test
  void testOnlyFilePathGivenAppendsNothing() {

    Main.main(new String[]{TEMP_PATH});

    String actual;
    try {
      actual = Files.readString(Path.of(TEMP_PATH));
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }

    assertEquals(FILE_TEXT, actual);
  }
}
