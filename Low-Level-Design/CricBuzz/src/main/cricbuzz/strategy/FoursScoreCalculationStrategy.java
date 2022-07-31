package src.main.cricbuzz.strategy;

import src.main.cricbuzz.models.Scorecard;

import java.util.Map;


public class FoursScoreCalculationStrategy implements ScoreCalculationStrategy {

    DefaultScoreCalcStrategy defaultScoreCalcStrategy;

    public FoursScoreCalculationStrategy(DefaultScoreCalcStrategy defaultScoreCalcStrategy) {
        this.defaultScoreCalcStrategy = defaultScoreCalcStrategy;
    }

    @Override
    public Scorecard calculateScore(String teamName, String player, int currentScore, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        int fours = scoreBoardPerTeams.get(teamName).get(player).getNoOfFours();
        int totalNoOfFours = fours + 1;
        Scorecard scorecard = defaultScoreCalcStrategy.calculateScore(teamName, player, currentScore, scoreBoardPerTeams);
        scorecard.setNoOfFours(totalNoOfFours);
        scoreBoardPerTeams.get(teamName).put(player, scorecard);
        return scorecard;
    }
}

