package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Kedar Erande
 *
 * TC: If B and C represent the two partitions, then size(B) >= 1, size(C) >= 1 and |max(B) - min(C)| is minimum possible. You have to find such a spliting and tell the minimum value of |max(B) - max(C)|.
 *
 * TC : Onlogn
 *
 */
public class OptimalPartitioning {
    public static void main(String[] args) {

        int A[] = {65, 38, 20, -58, 32, 75, -50, -80, -88, 82};
        System.out.println(solve(A));

    }

    private static int solve(int A[]) {

        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        int min_diff = Integer.MAX_VALUE;

        for (int i = 0; i < A.length-1; i++) {
            if (A[i + 1] - A[i] < min_diff) {
                min_diff = A[i + 1] - A[i];
            }
        }


        return min_diff;
    }
}
