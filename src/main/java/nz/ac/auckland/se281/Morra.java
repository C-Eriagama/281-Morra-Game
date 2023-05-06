package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // Game Variables
  private int round = 0;
  private String name = "";

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
  }

  public void play() {

    // Start new round and ask for input
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    boolean error = true;

    // Initialize variables
    String input = "";
    String fingerSum[] = new String[2];
    String playerFingersString = "";
    String playerSumString = "";

    // error checking
    while (error) {

      // Get input from user
      input = Utils.scanner.nextLine();
      fingerSum = input.split(" ");
      playerFingersString = fingerSum[0];
      playerSumString = fingerSum[1];

      // Check if input are integers
      if (!Utils.isInteger(playerFingersString) || !Utils.isInteger(playerSumString)) {
        MessageCli.INVALID_INPUT.printMessage();
        error = true;
        continue;
      }

      int playerFingers = Integer.parseInt(playerFingersString);
      int playerSum = Integer.parseInt(playerSumString);

      // Check if inputs are within range
      if (playerFingers < 1 || playerFingers > 5 || playerSum < 1 || playerSum > 10) {
        MessageCli.INVALID_INPUT.printMessage();
        error = true;
        continue;
      }

      // if no errors break out of loop
      error = false;
    }

    // Print out input if passes error checking
    MessageCli.PRINT_INFO_HAND.printMessage(name, playerFingersString, playerSumString);

  }

  public void showStats() {
  }
}
