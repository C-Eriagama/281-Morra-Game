package nz.ac.auckland.se281.players;

public abstract class Player {

  protected String name;
  protected int fingers;
  protected int sum;
  protected int points;

  public Player(String name) {
    this.name = name;
  }

  public abstract void setInput();

  public String getName() {
    return name;
  }

  public int getFingers() {
    return fingers;
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

  public int getPoints() {
    return points;
  }

  public String getPointsString() {
    return Integer.toString(points);
  }

  public void incrementPoints() {
    points++;
    return;
  }

  public void resetPoints() {
    points = 0;
    return;
  }
}
