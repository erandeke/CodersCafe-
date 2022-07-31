package src.main.cricbuzz.strategy;

import src.main.cricbuzz.models.Players;
import src.main.cricbuzz.models.Scorecard;

import java.util.Map;

public class Context implements ScoreCalculationStrategy {

    //this class does not the behvaior of the strategy todo just fyi
    ScoreCalculationStrategy scoreCalculationStrategy;

    public Context() {

    }

    public void setScoreCalculationStrategy(ScoreCalculationStrategy scoreCalculationStrategy) {
        this.scoreCalculationStrategy = scoreCalculationStrategy;
    }

    @Override
    public Scorecard calculateScore(String teamName, String player, int currentScore, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        return scoreCalculationStrategy.calculateScore(teamName, player, currentScore, scoreBoardPerTeams);
    }
}
