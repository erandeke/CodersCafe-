package src.main.cricbuzz.strategy;

import src.main.cricbuzz.models.Players;
import src.main.cricbuzz.models.Scorecard;

import java.util.Map;

public interface ScoreCalculationStrategy {

    public Scorecard calculateScore(String teamName, String player, int currentScore, Map<String, Map<String, Scorecard>> scoreBoardPerTeams);


}
