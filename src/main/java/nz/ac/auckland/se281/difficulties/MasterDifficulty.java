package nz.ac.auckland.se281.difficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.TopStrategy;

public class MasterDifficulty extends DifficultyLevel {

  private List<Integer> moveHistory;
  private TopStrategy topStrategy = new TopStrategy(moveHistory);
  private AverageStrategy averageStrategy = new AverageStrategy(moveHistory);

  public MasterDifficulty(List<Integer> moveHistory) {
    super(new RandomStrategy());
    this.moveHistory = moveHistory;
  }

  @Override
  public void updateStrategy() {

    // Alternate between Average Strategy and Top Strategy after 3 rounds
    if (moveHistory.size() >= 3) {

      if (moveHistory.size() % 2 == 0) {
        this.setStrategy(topStrategy);
      } else {
        this.setStrategy(averageStrategy);
      }

    }

    return;
  }

}
