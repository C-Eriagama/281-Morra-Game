package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.strategies.Strategy;

public abstract class DifficultyLevel {

    Strategy strategy;

    public DifficultyLevel(Strategy strategy) {
        this.strategy = strategy;
    }

}
