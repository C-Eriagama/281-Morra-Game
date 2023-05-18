package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Utils;

public class TopStrategy implements Strategy {

  private int fingers;
  private int sum;
  private List<Integer> moveHistory;

  public TopStrategy(List<Integer> moveHistory) {
    this.moveHistory = moveHistory;
  }

  @Override
  public int determineFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  @Override
  public int determineSum() {
    sum = fingers + calculateTop();
    return sum;
  }

  public int calculateTop() {
    int top = 0;
    int size = moveHistory.size();
    int topCount = 0;

    // Loop through moveHistory and find most played fingers
    for (int i = 0; i < size; i++) {
      int count = 0;

      // Count how many times a finger has been played
      for (int j = 0; j < size; j++) {
        if (moveHistory.get(j).equals(moveHistory.get(i))) {
          count++;
        }
      }

      // Check if count is greater than topCount
      if (count > topCount) {
        topCount = count;
        top = moveHistory.get(i);
      }
    }

    return top;
  }

}
