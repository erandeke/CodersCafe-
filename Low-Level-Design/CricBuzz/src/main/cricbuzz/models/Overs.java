package src.main.cricbuzz.models;

import java.util.HashMap;
import java.util.Map;

public class Overs {

    int overNumber;
    int extrasCounterPerOver;
    Map<Extras, Integer> map = new HashMap<>();

    public Overs(int size) {
      this.overNumber = size;
    }

    public Overs(int overNumber, int extrasCounterPerOver, Map<Extras, Integer> map) {
        this.overNumber = overNumber;
        this.extrasCounterPerOver = extrasCounterPerOver;
        this.map = map;
    }

    public int getOverNumber() {
        return overNumber;
    }

    public void setOverNumber(int overNumber) {
        this.overNumber = overNumber;
    }

    public int getExtrasCounterPerOver() {
        return extrasCounterPerOver;
    }

    public void setExtrasCounterPerOver(int extrasCounterPerOver) {
        this.extrasCounterPerOver = extrasCounterPerOver;
    }

    public Map<Extras, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Extras, Integer> map) {
        this.map = map;
    }
}
