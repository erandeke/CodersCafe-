package src.main.cricbuzz.models;

public enum MatchCodes {

    WICKET(1000), WIDE_BALL(1002);


    private Integer code;

    MatchCodes(Integer value) {
        this.code = value;
    }

    public Integer getMove() {
        return this.code;
    }

}
