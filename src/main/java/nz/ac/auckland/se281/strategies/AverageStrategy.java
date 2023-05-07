package nz.ac.auckland.se281.strategies;

import java.util.List;

import nz.ac.auckland.se281.Utils;

public class AverageStrategy implements Strategy {

  private int fingers;
  private int sum;
  private List<Integer> moveHistory;

  public AverageStrategy(List<Integer> moveHistory) {
    this.moveHistory = moveHistory;
  }

  @Override
  public int determineFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  @Override
  public int determineSum() {
    sum = fingers + calculateAverage();
    return sum;
  }

  public int calculateAverage() {
    int sum = 0;
    int size = moveHistory.size();

    // Loop through moveHistory and calculate average
    for (int i = 0; i < size; i++) {
      sum += moveHistory.get(i);
    }

    return Math.round((float) sum / size);
  }

}
