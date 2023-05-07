package nz.ac.auckland.se281.difficulties;

import java.util.List;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

    public static DifficultyLevel createDifficultyLevel(Difficulty difficulty, List<Integer> moveHistory) {

        // Create difficulty level based on difficulty
        switch (difficulty) {
            case EASY:

                return new EasyDifficulty();

            case MEDIUM:

                return new MediumDifficulty(moveHistory);
            case HARD:

                return null;

            default:
                return null;
        }
    }

}
