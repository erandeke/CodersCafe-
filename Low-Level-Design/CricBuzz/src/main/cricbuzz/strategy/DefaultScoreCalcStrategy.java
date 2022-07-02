package src.main.cricbuzz.strategy;

import src.main.cricbuzz.models.Players;
import src.main.cricbuzz.models.Scorecard;

import java.util.Map;

public class DefaultScoreCalcStrategy implements ScoreCalculationStrategy {


    @Override
    public Scorecard calculateScore(String teamName, String player, int currentScore, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        Scorecard scorecard1 = scoreBoardPerTeams.get(teamName).get(player);
        int noOfBallsPlayed = scoreBoardPerTeams.get(teamName).get(player).getNoOfBallsPlayed();
        int totalBallPlayed = noOfBallsPlayed + 1;
        int prevScore = scorecard1.getScore();
        int totalScore = prevScore + currentScore;
        scorecard1.setScore(totalScore);
        scorecard1.setNoOfBallsPlayed(totalBallPlayed);
        return scorecard1;
    }
}
