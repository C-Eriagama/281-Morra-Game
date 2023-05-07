package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {

    public static DifficultyLevel createDifficultyLevel(Difficulty difficulty) {

        // Create difficulty level based on difficulty
        switch (difficulty) {
            case EASY:

                return new EasyDifficulty();

            case MEDIUM:

                return null;
            case HARD:

                return null;

            default:
                return null;
        }
    }

}
