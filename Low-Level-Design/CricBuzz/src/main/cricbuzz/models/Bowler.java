package src.main.cricbuzz.models;

import java.util.List;

public class Bowler extends Players {


    int totalWicketsTaken;
    int noOfExtras;

    List<Overs> oversList;

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
    }

    public int getNoOfExtras() {
        return noOfExtras;
    }

    public void setNoOfExtras(int noOfExtras) {
        this.noOfExtras = noOfExtras;
    }

    public Bowler(String playerNumber) {
        super(playerNumber);
    }

    public Bowler(String playerNumber, String playerName, Scorecard scorecard) {
        super(playerNumber, playerName, scorecard);
    }

    public List<Overs> getOversList() {
        return oversList;
    }

    public void setOversList(List<Overs> oversList) {
        this.oversList = oversList;
    }
}
