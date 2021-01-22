package com.ss.sgerkin.day03.fileappender;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ss.sgerkin.day03.TestUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileAppenderTest {

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
    FileAppender.appendToFile(new File(TEMP_PATH), toAppend);

    String actual;
    try {
      actual = Files.readString(Path.of(TEMP_PATH));
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }

    assertEquals(expected, actual);
  }

}
