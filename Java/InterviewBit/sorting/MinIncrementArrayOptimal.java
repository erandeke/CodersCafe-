package sorting;

import java.util.Arrays;

/**
 * @author Kedar Erande
 * Problem: https://leetcode.com/problems/minimum-increment-to-make-array-unique/submissions/
 * TC : O(n)
 */
public class MinIncrementArrayOptimal {
    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 2, 1, 7};
        //int nums[] = {1, 1, 2};
        int x = new MinIncrementArrayOptimal().minIncrementForUnique(nums);
        System.out.println(x);
    }

    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i] += 1;
                ++ans;
            } else if (nums[i] < nums[i - 1]) {
                int diff = nums[i - 1] - nums[i];
                nums[i] += diff + 1;
                ans += diff + 1;
            }
        }
        return ans;
    }
}
