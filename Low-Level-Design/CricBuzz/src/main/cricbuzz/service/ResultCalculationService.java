package src.main.cricbuzz.service;

import src.main.cricbuzz.models.MatchStatus;
import src.main.cricbuzz.models.Team;

public class ResultCalculationService {

    public void calculateResults(Team team1, Team team2) {
        int totalScoreOfTeam1 = team1.getTotalScore();

        int totalScoreOfTeam2 = team2.getTotalScore();

        if (totalScoreOfTeam1 > totalScoreOfTeam2) {
            team1.setMatchStatus(MatchStatus.WON);
            System.out.println("Team " + "  " + team1.getTeamName() + "  " + "has" + "  " + team1.getMatchStatus() + "  " + "by" + "  " + (totalScoreOfTeam1 - totalScoreOfTeam2) + "  " + "runs");
        } else if (totalScoreOfTeam1 < totalScoreOfTeam2) {
            team2.setMatchStatus(MatchStatus.WON);
            System.out.println("Team " + "  " + team2.getTeamName() + "  " + "has" + " " + team2.getMatchStatus() + "  " + "by" + "  " + (totalScoreOfTeam2 - totalScoreOfTeam1) + "  " + "runs");
        }
    }
}
