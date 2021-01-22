package com.ss.sgerkin.day03.charcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ss.sgerkin.day03.TestUtils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  static final String TEMP_PATH = TestUtils.TEMP_PATH;
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

    TestUtils.writeFile();
  }

  @AfterEach
  void afterEach() {
    TestUtils.deleteFile();
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

}