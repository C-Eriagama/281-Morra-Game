package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.TopStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class HardDifficulty extends DifficultyLevel {

  private List<Integer> moveHistory;

  public HardDifficulty(List<Integer> moveHistory) {
    super(new RandomStrategy());
    this.moveHistory = moveHistory;
  }

  @Override
  public void updateStrategy() {
    if (moveHistory.size() == 3) {
      this.setStrategy(new TopStrategy(moveHistory));
    }
  }

}
