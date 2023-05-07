package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulties.DifficultyFactory;
import nz.ac.auckland.se281.difficulties.DifficultyLevel;

public class Morra {

  // Game Variables
  private int round = 0;
  private String name = "";
  private DifficultyLevel difficultyLevel;
  private String jarvis = "Jarvis";

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
    boolean error = true;

    // Initialize round variables
    String playerFingersString = "";
    String playerSumString = "";
    int playerFingers = 0;
    int playerSum = 0;

    // Get computer input
    int jarvisFingers = difficultyLevel.getStrategy().determineFingers();
    int jarvisSum = difficultyLevel.getStrategy().determineSum();

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

      playerFingers = Integer.parseInt(playerFingersString);
      playerSum = Integer.parseInt(playerSumString);

      // Check if inputs are within range
      if (playerFingers < 1 || playerFingers > 5 || playerSum < 1 || playerSum > 10) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }

      // if no errors break out of loop
      error = false;
    }

    // Print out User input and Jarvis input if passes error checking
    MessageCli.PRINT_INFO_HAND.printMessage(name, playerFingersString, playerSumString);
    MessageCli.PRINT_INFO_HAND.printMessage(jarvis, Integer.toString(jarvisFingers),
        Integer.toString(jarvisSum));

    // Calculate and output the winner of the round
    roundResult(playerFingers, playerSum, jarvisFingers, jarvisSum);
  }

  // Method to calculate the winner of the round
  public void roundResult(int playerFingers, int playerSum, int jarvisFingers, int jarvisSum) {
    // Initialise variables
    int sum = playerFingers + jarvisFingers;
    String winner;

    // Determines winner
    if (playerSum == jarvisSum || (playerSum != sum && jarvisSum != sum)) {
      winner = "DRAW";
    } else if (playerSum == sum) {
      winner = "HUMAN_WINS";
    } else {
      winner = "AI_WINS";
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(winner);
  }

  public void showStats() {
  }
}
