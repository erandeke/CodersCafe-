package src.main.cricbuzz.strategy;

import src.main.cricbuzz.models.Players;
import src.main.cricbuzz.models.Scorecard;

import java.util.Map;

public class SixesScoreCalculationStrategy implements ScoreCalculationStrategy {

    DefaultScoreCalcStrategy defaultScoreCalcStrategy;

    public SixesScoreCalculationStrategy(DefaultScoreCalcStrategy defaultScoreCalcStrategy) {
        this.defaultScoreCalcStrategy = defaultScoreCalcStrategy;
    }

    public Scorecard calculateScore(String teamName, String player, int currentScore, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        int sixes = scoreBoardPerTeams.get(teamName).get(player).getNoOfSix();
        int totalSixes = sixes + 1;
        Scorecard scorecard = defaultScoreCalcStrategy.calculateScore(teamName, player, currentScore, scoreBoardPerTeams);
        scorecard.setNoOfSix(totalSixes);
        scoreBoardPerTeams.get(teamName).put(player, scorecard);
        return scorecard;
    }
}
