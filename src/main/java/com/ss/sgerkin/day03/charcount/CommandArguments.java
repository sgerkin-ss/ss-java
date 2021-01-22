package com.ss.sgerkin.day03.charcount;

/**
 * A POJO for storing command line arguments for {@link FileCharCounter}.
 * <p>
 * Object properties are immutable and a new object should be created rather than mutated as
 * necessary.
 */
public class CommandArguments {

  private final String filePath;
  private final Character characterToFind;

  /**
   * Constructor.
   *
   * @param filePath        a path (relative or absolute) to a file to be read.
   * @param characterToFind the character on which to search the file.
   */
  public CommandArguments(String filePath, Character characterToFind) {
    this.filePath = filePath;
    this.characterToFind = characterToFind;
  }

  public String getFilePath() {
    return filePath;
  }

  public Character getCharacterToFind() {
    return characterToFind;
  }
}
