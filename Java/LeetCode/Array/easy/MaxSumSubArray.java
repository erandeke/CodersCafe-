package Array.easy;

/**
 * @author Kedar Erande
 * Problem : https://leetcode.com/problems/maximum-subarray/
 * TC : O(n);
 */
public class MaxSumSubArray {

    private static int MaxSum(int num[]) {
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum + num[i];
            max_sum = Math.max(sum, max_sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {

    }
}
