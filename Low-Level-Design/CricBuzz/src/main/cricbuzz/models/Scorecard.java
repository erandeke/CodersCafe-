package src.main.cricbuzz.models;

import com.kedar.imc.gamemodule.models.Player;

public class Scorecard {
    Integer score;
    Integer noOfFours;
    Integer noOfSix;
    Integer noOfBallsPlayed;

    Batter batter;

    Bowler bowler;


    public Scorecard() {

    }

    public Scorecard(Integer score, Integer noOfFours, Integer noOfSix, Integer noOfBallsPlayed) {
        this.score = score;
        this.noOfFours = noOfFours;
        this.noOfSix = noOfSix;
        this.noOfBallsPlayed = noOfBallsPlayed;
    }

    public Scorecard(Integer score, Integer noOfFours, Integer noOfSix, Integer noOfBallsPlayed, Batter batter, Bowler bowler) {
        this.score = score;
        this.noOfFours = noOfFours;
        this.noOfSix = noOfSix;
        this.noOfBallsPlayed = noOfBallsPlayed;
        this.batter = batter;
        this.bowler = bowler;
    }

    public static class ScoreCardBuilder {
        Integer score;
        Integer noOfFours;
        Integer noOfSix;
        Integer noOfBallsPlayed;

        Integer batterScore;


        public ScoreCardBuilder buildWithScore(Integer score) {
            this.score = score;
            return this;
        }

        public ScoreCardBuilder buildWithBatterScore(Integer batterScore) {
            this.batterScore = score;
            return this;
        }

        public ScoreCardBuilder buildWithNoOfFours(Integer noOfFours) {
            this.noOfFours = noOfFours;
            return this;
        }

        public ScoreCardBuilder buildWithNoOfSix(Integer noOfSix) {
            this.noOfSix = noOfSix;
            return this;
        }

        public ScoreCardBuilder buildWithNoOfBallsPlayed(Integer noOfBallsPlayed) {
            this.noOfBallsPlayed = noOfBallsPlayed;
            return this;
        }

        public Scorecard build() {
            Scorecard sc = new Scorecard();
            sc.score = score;
            sc.noOfFours = noOfFours;
            sc.noOfSix = noOfSix;
            sc.noOfBallsPlayed = noOfBallsPlayed;
            return sc;
        }
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNoOfFours() {
        return noOfFours;
    }

    public void setNoOfFours(int noOfFours) {
        this.noOfFours = noOfFours;
    }

    public Integer getNoOfSix() {
        return noOfSix;
    }

    public void setNoOfSix(int noOfSix) {
        this.noOfSix = noOfSix;
    }

    public Integer getNoOfBallsPlayed() {
        return noOfBallsPlayed;
    }

    public void setNoOfBallsPlayed(int noOfBallsPlayed) {
        this.noOfBallsPlayed = noOfBallsPlayed;
    }
    //do builder pattern for building the object


    public Batter getBatter() {
        return batter;
    }

    public void setBatter(Batter batter) {
        this.batter = batter;
    }

    public Bowler getBowler() {
        return bowler;
    }

    public void setBowler(Bowler bowler) {
        this.bowler = bowler;
    }

    @Override
    public String toString() {
        return "Scorecard{" + "score=" + score + ", noOfFours=" + noOfFours + ", noOfSix=" + noOfSix + ", noOfBallsPlayed=" + noOfBallsPlayed + '}';
    }
}
