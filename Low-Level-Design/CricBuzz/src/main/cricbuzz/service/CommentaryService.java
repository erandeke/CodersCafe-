package src.main.cricbuzz.service;

import src.main.cricbuzz.models.Scorecard;
import src.main.cricbuzz.models.Team;

import java.util.Map;

public class CommentaryService {


    public void calculateTeamScoreAndWickets(Team team, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        Map<String, Scorecard> scoreMap = scoreBoardPerTeams.get(team.getTeamName());
        Integer sumOfIndividualScores = scoreMap.values().stream().map(x -> x.getScore()).mapToInt(Integer::valueOf).sum();
        Integer totalSScore = Math.addExact(sumOfIndividualScores, team.getExtras() == null ? 0 : team.getExtras());
        team.setTotalScore(totalSScore);
        System.out.println();
        System.out.println("Score of Team   " + "  " + team.getTeamName() + " is " + team.getTotalScore());
        System.out.println();
        System.out.println();
        System.out.println("Wickets Fallen   " + "  " + team.getTeamName() + " is " + team.getTotalNoOfWickets());
    }


    public void printIndividualScoresFromTheTeam(String teamName, int over, Map<String, Map<String, Scorecard>> scoreBoardPerTeams) {
        Map<String, Scorecard> scoreMap = scoreBoardPerTeams.get(teamName);
        System.out.println();
        System.out.println("For team" + "   " + teamName + " " + "Below is the scoreboard for Over" + "  " + over);
        scoreMap.forEach((K, V) -> System.out.println("Player is" + "  " + K + " " + V.toString()));
    }
}
