package array;

import java.util.HashMap;

/**
 * @author Kedar Erande
 * <p>
 * PS:
 * Contiguous Array
 * Given an array of integers A consisting of only 0 and 1.
 * <p>
 * Find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * TC: O(n) Sc: O(1);
 */
public class LongestEquality1And0 {
    public static void main(String[] args) {
        int A[] = new int[]{1, 0, 1, 0, 1};
        System.out.println(solve(A));

    }

    public static int solve(int[] A) {

        //replace all 0 with -1
        //If any subarray has sum = 0 that means it has equal number of 0's and 1's
        int prefix_sum = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                A[i] = -1;
            }
        }

        //calculate prefix sum array from 0 to i;
        for (int i = 0; i < A.length; i++) {
            prefix_sum = prefix_sum + A[i];
            A[i] = prefix_sum;
        }

        //calculate  maximum length of a contiguous subarray with equal number of 0 and 1.

        int ans = 0;
        int max_ans = 0;
        int first_occ = 0;
        int last_occ = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        for (int i = 0; i < A.length; i++) {
            if (hashMap.containsKey(A[i])) {
                first_occ = hashMap.get(A[i]);
                last_occ = i;
                ans = last_occ - first_occ;
                if (ans > max_ans)
                    max_ans = ans;

            } else {
                hashMap.put(A[i], i);
            }
        }

        return max_ans;

    }
}
