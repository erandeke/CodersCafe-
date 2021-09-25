package array;

import java.util.Arrays;

/**
 * @author Kedar Erande
 * <p>
 * PS: Find the minmum from the windowsize given
 * Approach : find the min from first window then slide the window by 1 subtarct it from A[i] since A[i] will be smallest
 * as we are going to sort the array initially then return the min of received from traversing every window
 * TC: Ologn
 */
public class MinimumPuzzle {
    public static void main(String[] args) {

        //int A[] = {10, 12, 10, 7, 5, 22};
        int A[] = {66, 23, 687, 252, 187, 114, 789, 527, 129, 474, 679, 119, 687, 92, 578, 332, 781, 499, 597, 370, 848, 248, 496, 641, 714, 572, 399, 187, 910, 638, 100, 975, 660, 786, 227, 198, 252, 367, 725};
        int B = 29;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= A.length - B; i++) {
            res = Math.min(res, A[i + B - 1] - A[i]);
        }
        return res;
    }
}
