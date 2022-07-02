package src.main.cricbuzz.models;


public class Batter extends Players {


    int batterScore;


    public Batter(String playerNumber) {
        super(playerNumber);
    }

    public Batter(String playerNumber, String playerName, Scorecard scorecard) {
        super(playerNumber, playerName, scorecard);
    }

    public int getBatterScore() {
        return batterScore;
    }

    public void setBatterScore(int batterScore) {
        this.batterScore = batterScore;
    }
}
