package src.main.cricbuzz.models;

//todo can be more meaningful
public class MatchUtil {
    int strikerIndex;
    int nonStrikerIndex;

    int indexForBattingOrder;

    public int getStrikerIndex() {
        return strikerIndex;
    }

    public void setStrikerIndex(int strikerIndex) {
        this.strikerIndex = strikerIndex;
    }

    public int getNonStrikerIndex() {
        return nonStrikerIndex;
    }

    public void setNonStrikerIndex(int nonStrikerIndex) {
        this.nonStrikerIndex = nonStrikerIndex;
    }

    public int getIndexForBattingOrder() {
        return indexForBattingOrder;
    }

    public void setIndexForBattingOrder(int indexForBattingOrder) {
        this.indexForBattingOrder = indexForBattingOrder;
    }
}
