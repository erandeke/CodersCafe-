package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kedar Erande
 */
public class MergeOverlappingIntervals {
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        int i = 1;
        while (i < intervals.length) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s <= end) {
                end = Math.max(e, end);
            } else {
                ans.add(new int[]{start, end});
                start = s;
                end = e;
            }
            i++;

        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
       /* int intervals[][] = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}


        };*/
        int intervals[][] = {
                {1, 4},
                {0, 4}
        };

        int d[][] = MergeOverlappingIntervals.merge(intervals);

    }
}
