package nz.ac.auckland.se281.difficulties;

import java.util.List;

import nz.ac.auckland.se281.strategies.AverageStrategy;
import nz.ac.auckland.se281.strategies.RandomStrategy;

public class MediumDifficulty extends DifficultyLevel {

    List<Integer> moveHistory;

    public MediumDifficulty(List<Integer> moveHistory) {
        super(new RandomStrategy());
        this.moveHistory = moveHistory;
    }

    @Override
    public void updateStrategy() {
        if (moveHistory.size() == 4) {
            this.setStrategy(new AverageStrategy(moveHistory));
        }
    }

}
