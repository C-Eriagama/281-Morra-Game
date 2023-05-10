package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.difficulties.DifficultyLevel;

public class Ai {

  private String name;
  private int fingers;
  private int sum;
  private DifficultyLevel difficultyLevel;

  public Ai(String name, DifficultyLevel difficulty) {
    this.name = name;
    this.difficultyLevel = difficulty;
  }

  public String getName() {
    return name;
  }

  public int getFingers() {
    return fingers;
  }

  public void setInput() {
    fingers = difficultyLevel.getStrategy().determineFingers();
    sum = difficultyLevel.getStrategy().determineSum();
    return;
  }

  public String getFingersString() {
    return Integer.toString(fingers);
  }

  public int getSum() {
    return sum;
  }

  public String getSumString() {
    return Integer.toString(sum);
  }
}