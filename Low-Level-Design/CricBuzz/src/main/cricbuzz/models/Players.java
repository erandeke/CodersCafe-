package src.main.cricbuzz.models;


public abstract class Players {
    String playerNumber;
    String playerName;
    Scorecard scorecard;


    public Players(String playerNumber) {
        this.playerNumber = playerNumber;
    }


    public Players(String playerNumber, String playerName, Scorecard scorecard) {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.scorecard = scorecard;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(String playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public void setScorecard(Scorecard scorecard) {
        this.scorecard = scorecard;
    }
}
