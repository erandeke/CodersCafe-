package src.main.cricbuzz.service;

public class RotationStrikeAlgorithm {
    int posStriker;
    int posNonStriker;

    public int getPosStriker() {
        return posStriker;
    }

    public void setPosStriker(int posStriker) {
        this.posStriker = posStriker;
    }

    public int getPosNonStriker() {
        return posNonStriker;
    }

    public void setPosNonStriker(int posNonStriker) {
        this.posNonStriker = posNonStriker;
    }

    public void rotateStriker(int posStriker, int posNonStriker) {
        int temp = posStriker;
        posStriker = posNonStriker;
        posNonStriker = temp;
        setPosStriker(posStriker);
        setPosNonStriker(posNonStriker);

    }
}
