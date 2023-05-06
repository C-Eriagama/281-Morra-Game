package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int round = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    //Start new round and ask for input
    round++;
    MessageCli.START_ROUND.printMessage(Integer.toString(round));
    MessageCli.ASK_INPUT.printMessage();

    //Get input from user
    String input = Utils.scanner.nextLine();
    String fingerSum [] = input.split(" ");
    String playerFingersString = fingerSum[0];
    String playerSumString = fingerSum[1];

    //error checking
    if(!Utils.isInteger(playerFingersString) || !Utils.isInteger(playerSumString)){
      MessageCli.INVALID_INPUT.printMessage();
      return;
    }

    int playerFingers = Integer.parseInt(playerFingersString);
    int playerSum = Integer.parseInt(playerSumString);

    if(playerFingers < 1 || playerFingers > 5 || playerSum < 1 || playerSum > 10){
      MessageCli.INVALID_INPUT.printMessage();
      return;
    }


  }

  public void showStats() {}
}
