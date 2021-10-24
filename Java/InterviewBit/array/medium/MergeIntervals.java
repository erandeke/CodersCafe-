package array.medium;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        Interval interval = new Interval(8, 9);
        // Interval interval = new Interval(2, 5);
        ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(5, 7));
        arr.add(new Interval(10, 11));


        ArrayList<Interval> mergedList = insert(arr, interval);
        for (Interval i : mergedList) {
            System.out.println(i.getStart() + "    " + i.getEnd());
        }

    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> arrayList = new ArrayList<>();
        arrayList.add(new Interval(newInterval.getStart(), newInterval.end));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start = newInterval.getStart();
        int end = newInterval.getEnd();
        for (int i = 0; i < intervals.size(); i++) {
            int intervals_start = intervals.get(i).getStart();
            int intervals_end = intervals.get(i).getEnd();
            if (!((intervals_start > end) || (start > intervals_end))) {
                int potential_min = Math.min(intervals_start, start);
                int potential_max = Math.max(intervals_end, end);
                min = potential_min < min ? potential_min : min;
                max = potential_max > max ? potential_max : max;
                if (!arrayList.isEmpty()) {
                    Interval interval = arrayList.get(arrayList.size() - 1);
                    interval.setEnd(max);
                    interval.setStart(min);
                    arrayList.set(arrayList.size() - 1, interval);
                } else {
                    arrayList.add(new Interval(min, max));
                }

            } else {
                arrayList.add(new Interval(intervals_start, intervals_end));
            }

        }

        return arrayList;
    }
}
/*

INPUTs:
 ArrayList<Interval> arr = new ArrayList<>();
        arr.add(new Interval(1, 2));
        arr.add(new Interval(3, 6));
        //arr.add(new Interval(1, 3));
        //arr.add(new Interval(6, 9));


         //arr.add(new Interval(1, 3));
        //arr.add(new Interval(6, 9));

 */