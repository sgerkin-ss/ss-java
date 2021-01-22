package com.ss.sgerkin.day03.charcount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  static final String TEMP_PATH = "/temp/test.txt";
  static final ByteArrayOutputStream stdout = new ByteArrayOutputStream();
  static final ByteArrayOutputStream stderr = new ByteArrayOutputStream();

  @BeforeAll
  static void beforeAll() {
    System.setOut(new PrintStream(stdout));
    System.setErr(new PrintStream(stderr));
  }

  @AfterAll
  static void afterAll() {
    System.setOut(System.out);
    System.setErr(System.err);
  }

  @BeforeEach
  void beforeEach() {
    stdout.reset();
    stderr.reset();

    var file = new File(TEMP_PATH);
    try (var writer = new FileWriter(file)) {
      writer.write("The quick red fox jumped over the lazy brown dog.");
    } catch (IOException ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex);
    }
  }

  @AfterEach
  private void afterEach() {
    var file = new File(TEMP_PATH);
    file.delete();
  }

  @Test
  void testSingleOccurrenceOfCharacter() {
    var expected = "There was 1 occurrence of 'q'";
    Main.main(new String[]{TEMP_PATH, "q"});
    var actual = stdout.toString().trim();
    assertEquals(expected, actual);
  }

  @Test
  void testCountIsCaseSensitive() {
    var expected = "There was 1 occurrence of 't'";
    Main.main(new String[]{TEMP_PATH, "t"});
    var actual = stdout.toString().trim();
    assertEquals(expected, actual);
  }

  @Test
  void testMultipleOccurrences() {
    var expected = "There were 3 occurrences of 'r'";
    Main.main(new String[]{TEMP_PATH, "r"});
    var actual = stdout.toString().trim();
    assertEquals(expected, actual);
  }

  @Test
  void testInvalidPathThrowsException() {
    assertThrows(RuntimeException.class, () -> Main.main(new String[]{" ", "a"}));
    assertThrows(RuntimeException.class,
                 () -> Main.main(new String[]{"japwoeigjapogijoijaweof", "a"}));
  }

  @Test
  void testInvalidArgLengthThrowsException() {
    assertThrows(RuntimeException.class, () -> Main.main(null));
    assertThrows(RuntimeException.class, () -> Main.main(new String[]{TEMP_PATH}));
  }

  @Test
  void testInvalidCharThrowsException() {
    assertThrows(RuntimeException.class, () -> Main.main(new String[]{TEMP_PATH, "ah"}));
  }
}