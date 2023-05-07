package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Utils;

public class RandomStrategy implements Strategy {

  private int fingers;
  private int sum;

  @Override
  public int determineFingers() {
    fingers = Utils.getRandomNumber(1, 5);
    return fingers;
  }

  @Override
  public int determineSum() {
    sum = Utils.getRandomNumber(fingers + 1, fingers + 5);
    return sum;
  }

}
