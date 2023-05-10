package nz.ac.auckland.se281.players;

import nz.ac.auckland.se281.MessageCli;
import nz.ac.auckland.se281.Utils;

public class Human {

  private String name;
  private int fingers;
  private int sum;

  public Human(String name) {
    this.name = name;
  }

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

  public void setInput() {
    // Initialise variables
    boolean error = true;
    String playerFingersString = "";
    String playerSumString = "";

    // error checking
    while (error) {

      // Get input from user
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();

      // Check if input contains a space
      if (!input.contains(" ")) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      // Split input into fingers and sum
      String[] fingerSum = input.split(" ");
      playerFingersString = fingerSum[0];
      playerSumString = fingerSum[1];

      // Check valid number of inputs;
      if (fingerSum.length != 2) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      // Check if inputs are integers
      if (!Utils.isInteger(playerFingersString) || !Utils.isInteger(playerSumString)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      fingers = Integer.parseInt(playerFingersString);
      sum = Integer.parseInt(playerSumString);

      // Check if inputs are within range
      if (fingers < 1 || fingers > 5 || sum < 1 || sum > 10) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      // if no errors break out of loop
      error = false;
    }
  }
}
