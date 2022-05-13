package Array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
class IntervalTest {
    int start;
    int end;

    public IntervalTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class InsertInterval {
    public static List<IntervalTest> insert(List<IntervalTest> intervals, IntervalTest newInterval) {

        List<IntervalTest> result = new ArrayList<>();
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;


        while (i < intervals.size() && intervals.get(i).end < start) {
            result.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start <= end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        result.add(new IntervalTest(start, end));

        while (i < intervals.size()) result.add(intervals.get(i++));

        return result;

    }


    public static void main(String[] args) {
        List<IntervalTest> intervals = new ArrayList<>();
        intervals.add(new IntervalTest(1, 2));
        intervals.add(new IntervalTest(3, 5));
        intervals.add(new IntervalTest(6, 7));
        intervals.add(new IntervalTest(8, 10));
        intervals.add(new IntervalTest(12, 16));
        IntervalTest newinterval = new IntervalTest(4, 8);
        insert(intervals, newinterval);


    }
}
