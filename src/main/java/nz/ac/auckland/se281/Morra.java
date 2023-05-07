package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulties.DifficultyFactory;
import nz.ac.auckland.se281.difficulties.DifficultyLevel;

public class Morra {

  // Game Variables
  private int round = 0;
  private String name = "";
  private DifficultyLevel difficultyLevel;

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);

    // Create difficulty level
    difficultyLevel = DifficultyFactory.createDifficultyLevel(difficulty);
  }

  public void play() {

    // Start new round and ask for input
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();
    boolean error = true;

    // Initialize variables
    String playerFingersString = "";
    String playerSumString = "";

    // error checking
    while (error) {

      // Get input from user
      String input = Utils.scanner.nextLine();
      String[] fingerSum = input.split(" ");
      playerFingersString = fingerSum[0];
      playerSumString = fingerSum[1];

      // Check if inputs are integers
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

    // Get computer input
    int jarvisFingers = difficultyLevel.getStrategy().determineFingers();
    int jarvisSum = difficultyLevel.getStrategy().determineSum();

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(jarvisFingers),
        Integer.toString(jarvisSum));
  }

  public void showStats() {
  }
}
