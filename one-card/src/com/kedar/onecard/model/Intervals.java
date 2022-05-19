package com.kedar.onecard.model;

import java.util.*;

/**
 * @author Kedar Erande
 */
public class Intervals {
    int startTime;
    int endTime;
    List<Intervals> intervals;

    public Intervals() {
        this.intervals = new ArrayList<>();

    }

    public Intervals(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.intervals = new LinkedList<>();

    }

    public void populateIntervalsInventory() {
        startTime = 8;//8 am
        endTime = startTime + 1;
        intervals.add(new Intervals(startTime, endTime));
        int closeTime = 18;
        while (endTime < closeTime) {
            startTime = endTime;
            endTime = startTime + 1;
            intervals.add(new Intervals(startTime, endTime));

        }
        setIntervals(intervals);
    }


    public void printIntervals() {

        for (Intervals i : intervals) {
            System.out.println("startTime--->" + i.startTime + "endTime" + "--->" + i.endTime);
        }
    }

    @Override
    public String toString() {
        return "Intervals{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", intervals=" + intervals +
                '}';
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public List<Intervals> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<Intervals> intervals) {
        this.intervals = intervals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Intervals intervals1 = (Intervals) o;

        if (this.startTime != intervals1.startTime)
            return false;
        if (this.endTime != intervals1.endTime)
            return false;
        return intervals.equals(intervals1.intervals);


    }

    @Override
    public int hashCode() {
        int result = startTime;
        result = 31 * result + endTime;
        result = 31 * result + intervals.hashCode();
        return result;
    }
}
