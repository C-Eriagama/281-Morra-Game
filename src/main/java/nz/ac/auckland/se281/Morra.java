package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.difficulties.DifficultyFactory;
import nz.ac.auckland.se281.difficulties.DifficultyLevel;
import nz.ac.auckland.se281.players.Ai;
import nz.ac.auckland.se281.players.Human;
import nz.ac.auckland.se281.players.Player;

public class Morra {

  // Game Variables
  private Human player;
  private Ai jarvis;
  private int round = 0;
  private DifficultyLevel difficultyLevel;
  private List<Integer> moveHistory = new ArrayList<>();

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // Create player
    player = new Human(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(player.getName());

    // reset variables
    moveHistory.clear();
    round = 0;

    // Create difficulty level
    difficultyLevel = DifficultyFactory.createDifficultyLevel(difficulty, moveHistory);
    jarvis = new Ai("Jarvis", difficultyLevel);
  }

  public void play() {

    // Start new round and ask for input
    round++;
    difficultyLevel.updateStrategy();
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // Get input from player and Jarvis
    player.setInput();
    jarvis.setInput();

    moveHistory.add(player.getFingers());

    // Print out User input and Jarvis input if passes error checking
    printHandInfo(player);
    printHandInfo(jarvis);

    // Calculate and output the winner of the round
    determineRoundResult();
  }

  // Method to print out the hand information of a player
  public void printHandInfo(Player player) {
    String name = player.getName();
    String fingers = Integer.toString(player.getFingers());
    String sum = Integer.toString(player.getSum());
    MessageCli.PRINT_INFO_HAND.printMessage(name, fingers, sum);
  }

  // Method to calculate the winner of the round
  public void determineRoundResult() {
    // Initialise variables
    int sum = player.getFingers() + jarvis.getFingers();
    int humanSum = player.getSum();
    int aiSum = jarvis.getSum();
    String winner;

    // Determines winner
    if (humanSum == aiSum || (humanSum != sum && aiSum != sum)) {
      winner = "DRAW";
    } else if (humanSum == sum) {
      winner = "HUMAN_WINS";
    } else {
      winner = "AI_WINS";
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(winner);
  }

  public void showStats() {
  }
}
