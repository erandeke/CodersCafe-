package src.main.cricbuzz.service;

import src.main.cricbuzz.constants.Constants;
import src.main.cricbuzz.models.*;
import src.main.cricbuzz.strategy.Context;
import src.main.cricbuzz.strategy.DefaultScoreCalcStrategy;
import src.main.cricbuzz.strategy.FoursScoreCalculationStrategy;
import src.main.cricbuzz.strategy.SixesScoreCalculationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ScoreCardGenerator : Utility to generate score card for both the playing teams
 */
public class ScoreCardGenerator {


    private Map<String, Map<String, Scorecard>> scoreBoardPerTeams;
    private Context context;
    private RotationStrikeAlgorithm rotationStrikeAlgorithm;

    private CommentaryService commentaryService;

    public ScoreCardGenerator(Context context) {
        this.context = context;
    }

    public ScoreCardGenerator() {
        scoreBoardPerTeams = new HashMap<>();
        this.context = new Context();
        this.rotationStrikeAlgorithm = new RotationStrikeAlgorithm();
        this.commentaryService = new CommentaryService();


    }


    public void computeScoresForRotatingStrikers(String teamName, String player, int score, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        context.setScoreCalculationStrategy(new DefaultScoreCalcStrategy());
        context.calculateScore(teamName, player, score, scoreBoardPerTeams);
    }

    public Map<String, Map<String, Scorecard>> getScoreBoardPerTeams() {
        return scoreBoardPerTeams;
    }

    public void setScoreBoardPerTeams(Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        this.scoreBoardPerTeams = scoreBoardPerTeams;
    }

    /**
     * @param team        : Team playing currently
     * @param overs       :Overs allowed to play
     * @param playersList : Battter list
     * @param runsPerBall : Runs score per ball
     *                    WICKET code : 1000
     *                    Wide Ball code: 1002
     *                    No Ball code : 1003
     */

    public void generateScoreCard(Team team, Overs overs, List<Players> playersList, List<List<Integer>> runsPerBall) {
        if (!scoreBoardPerTeams.containsKey(team.getTeamName())) {
            scoreBoardPerTeams.put(team.getTeamName(), new HashMap<>());
            for (Players players : playersList) {
                scoreBoardPerTeams.get(team.getTeamName()).put(players.getPlayerNumber(), new Scorecard(0, 0, 0, 0));
            }

        }
        int over = 1;
        int strikerIndex = 0;
        rotationStrikeAlgorithm.setPosStriker(strikerIndex);
        int nonStrikerIndex = 1;
        rotationStrikeAlgorithm.setPosNonStriker(nonStrikerIndex);
        int indexForBattingOrder = 1;
        int totalNoOfWickets = 0;
        int extras = 0;
        String teamName = team.getTeamName();
        boolean isOverChanged = false;
        Integer totalNoOfBallsPlayedByEachPlayer = 0;
        List<Integer> actionOnBalls = runsPerBall.get(0);
        while (over <= overs.getOverNumber() && indexForBattingOrder < playersList.size()) {
            for (int i = 0; i < actionOnBalls.size(); i++) {
                switch (actionOnBalls.get(i)) {
                    case 1000:
                        Scorecard scorecard = scoreBoardPerTeams.get(teamName).get(playersList.get(rotationStrikeAlgorithm.getPosStriker()).getPlayerNumber());
                        totalNoOfBallsPlayedByEachPlayer = scorecard.getNoOfBallsPlayed() + 1;
                        scorecard.setNoOfBallsPlayed(totalNoOfBallsPlayedByEachPlayer);
                        indexForBattingOrder = indexForBattingOrder + 1; //get the next Batsman
                        strikerIndex = indexForBattingOrder;
                        rotationStrikeAlgorithm.setPosStriker(strikerIndex);
                        totalNoOfWickets++;
                        team.setTotalNoOfWickets(totalNoOfWickets);
                        break;
                    case 1002:
                    case 1003:
                        extras++;
                        team.setExtras(extras);
                        break;
                    case 1:
                    case 3:
                        computeScoresForRotatingStrikers(teamName, playersList.get(rotationStrikeAlgorithm.getPosStriker()).getPlayerNumber(), actionOnBalls.get(i), scoreBoardPerTeams);
                        rotationStrikeAlgorithm.rotateStriker(rotationStrikeAlgorithm.posStriker, rotationStrikeAlgorithm.posNonStriker);
                        break;
                    case 4:
                        context.setScoreCalculationStrategy(new FoursScoreCalculationStrategy(new DefaultScoreCalcStrategy()));
                        context.calculateScore(teamName, playersList.get(rotationStrikeAlgorithm.getPosStriker()).getPlayerNumber(), actionOnBalls.get(i), scoreBoardPerTeams);
                        break;
                    case 6:
                        context.setScoreCalculationStrategy(new SixesScoreCalculationStrategy(new DefaultScoreCalcStrategy()));
                        context.calculateScore(teamName, playersList.get(rotationStrikeAlgorithm.getPosStriker()).getPlayerNumber(), actionOnBalls.get(i), scoreBoardPerTeams);
                        break;
                    default:
                        context.setScoreCalculationStrategy(new DefaultScoreCalcStrategy());
                        context.calculateScore(teamName, playersList.get(rotationStrikeAlgorithm.getPosStriker()).getPlayerNumber(), actionOnBalls.get(i), scoreBoardPerTeams);
                        break;

                }
            }
            commentaryService.printIndividualScoresFromTheTeam(teamName, over, scoreBoardPerTeams);
            over++;
            isOverChanged = true;
            if (isOverChanged) {
                actionOnBalls = runsPerBall.get(1);
                rotationStrikeAlgorithm.rotateStriker(rotationStrikeAlgorithm.getPosStriker(), rotationStrikeAlgorithm.getPosNonStriker());
            }

        }
        commentaryService.calculateTeamScoreAndWickets(team, scoreBoardPerTeams);
    }
}