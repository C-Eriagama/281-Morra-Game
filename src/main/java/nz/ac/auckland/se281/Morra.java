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
  private boolean gameStarted = false;
  private int pointsToWin;
  private DifficultyLevel difficultyLevel;
  private List<Integer> moveHistory = new ArrayList<>();

  public Morra() {
  }

  public void newGame(Difficulty difficulty, int pointsWin, String[] options) {

    // Create player
    player = new Human(options[0]);
    MessageCli.WELCOME_PLAYER.printMessage(player.getName());

    // reset game variables
    moveHistory.clear();
    round = 0;
    jarvis.resetPoints();
    player.resetPoints();
    gameStarted = true;

    // Create difficulty level
    difficultyLevel = DifficultyFactory.createDifficultyLevel(difficulty, moveHistory);
    jarvis = new Ai("Jarvis", difficultyLevel);
    pointsToWin = pointsWin;
  }

  public void play() {

    // Check if game has started
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Start new round and ask for input
    round++;
    difficultyLevel.updateStrategy();
    MessageCli.START_ROUND.printMessage(Integer.toString(round));

    // Get input from player and Jarvis
    player.setInput();
    jarvis.setInput();

    moveHistory.add(player.getFingers());

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

    // Determines winner and increments their points
    if (humanSum == aiSum || (humanSum != sum && aiSum != sum)) {
      winner = "DRAW";
    } else if (humanSum == sum) {
      winner = "HUMAN_WINS";
      player.incrementPoints();
    } else {
      winner = "AI_WINS";
      jarvis.incrementPoints();
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(winner);

    if (player.getPoints() == pointsToWin) {
      MessageCli.END_GAME.printMessage(player.getName(), Integer.toString(round));
      gameStarted = false;
    } else if (jarvis.getPoints() == pointsToWin) {
      MessageCli.END_GAME.printMessage(jarvis.getName(), Integer.toString(round));
      gameStarted = false;
    }
  }

  public void showStats() {
  }
}
