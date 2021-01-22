package com.ss.sgerkin.day03.utils;

/**
 * A POJO for storing command line arguments for {@link com.ss.sgerkin.day03.charcount.FileCharCounter}
 * and {@link com.ss.sgerkin.day03.fileappender.FileAppender}.
 * <p>
 * Object properties are immutable and a new object should be created rather than mutated as
 * necessary.
 */
public class CommandArguments {

  private final String filePath;
  private final String stringToUse;

  /**
   * Constructor.
   *
   * @param filePath    a path (relative or absolute) to a file to be read.
   * @param stringToUse a string to be used with the filepath.
   */
  public CommandArguments(String filePath, String stringToUse) {
    this.filePath = filePath;
    this.stringToUse = stringToUse;
  }

  public String getFilePath() {
    return filePath;
  }

  public String getStringToUse() {
    return stringToUse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CommandArguments that = (CommandArguments) o;

    if (!getFilePath().equals(that.getFilePath())) {
      return false;
    }
    return getStringToUse().equals(that.getStringToUse());
  }

  @Override
  public int hashCode() {
    int result = getFilePath().hashCode();
    result = 31 * result + getStringToUse().hashCode();
    return result;
  }
}
