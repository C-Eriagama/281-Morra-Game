package nz.ac.auckland.se281.difficulties;

import nz.ac.auckland.se281.strategies.Strategy;

public abstract class DifficultyLevel {

    Strategy strategy;

    public DifficultyLevel(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}
