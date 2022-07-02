package src.main.cricbuzz.models;

import src.main.cricbuzz.service.ScoreCardGenerator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Team {

    private String teamName;
    private List<Players> playersList;
    private Scorecard scorecard;
    int totalScore;
    private MatchStatus matchStatus;
    private Integer extras;

    private Integer totalNoOfWickets;

    private ScoreCardGenerator scoreCardGenerator;

    Map<String, Scorecard> teamScoreCard;

    public Team() {

    }

    public Team(String teamName, List<Players> playersList) {
        this.teamName = teamName;
        this.playersList = playersList;
    }

    public Team(String teamName, List<Players> playersList, Scorecard scorecard, int totalScore, MatchStatus matchStatus, Integer extras, Integer totalNoOfWickets, ScoreCardGenerator scoreCardGenerator) {
        this.teamName = teamName;
        this.playersList = playersList;
        this.scorecard = scorecard;
        this.totalScore = totalScore;
        this.matchStatus = matchStatus;
        this.extras = extras;
        this.totalNoOfWickets = totalNoOfWickets;
        this.scoreCardGenerator = scoreCardGenerator;
    }

    public List<Players> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<Players> playersList) {
        this.playersList = playersList;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public Integer getExtras() {
        return extras;
    }

    public void setExtras(Integer extras) {
        this.extras = extras;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalNoOfWickets() {
        return totalNoOfWickets;
    }

    public void setTotalNoOfWickets(Integer totalNoOfWickets) {
        this.totalNoOfWickets = totalNoOfWickets;
    }


}
