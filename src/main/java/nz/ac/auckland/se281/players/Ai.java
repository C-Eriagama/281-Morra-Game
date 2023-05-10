package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.difficulties.DifficultyLevel;

public class Ai extends Player {

  private DifficultyLevel difficultyLevel;

  public Ai(String name, DifficultyLevel difficulty) {
    super(name);
    this.difficultyLevel = difficulty;
    return;
  }

  @Override
  public void setInput() {
    fingers = difficultyLevel.getStrategy().determineFingers();
    sum = difficultyLevel.getStrategy().determineSum();
  }

}