package array;

/**
 * @author Kedar Erande
 * <p>
 * PS: check if the time interval is overlapping
 * //Naive Approach : Take the interval one and store in list
 * //get the second interval start and end check if they are part of it but it will take O(n) for large number
 * <p>
 * Efficient approach:
 * Maintain the start and end of the intervals and check if end of A interval is lesser than start of B interval
 * and end of B interval is less than start of A interval
 * Only 2 intervals will be given
 * - Should be sorted
 */

class Interval {
    private int start;
    private int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
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


public class IntervalOverlapOne {

    public static void main(String[] args) {
        Interval a = new Interval(2, 8);
        Interval b = new Interval(5, 12);

        boolean val = isOverlap(a, b);
        System.out.println(val);


    }

    private static boolean isOverlap(Interval a, Interval b) {
        if (a.getEnd() < b.getStart() || b.getEnd() < a.getStart())
            return false;
        return true;
    }

}
/*

Test cases:
1)(4,7) (10,12) --> false  as start and end of B falls apart from A
2)(2,8) (5,12)-->true as 5 to 8 gets overlap

 */