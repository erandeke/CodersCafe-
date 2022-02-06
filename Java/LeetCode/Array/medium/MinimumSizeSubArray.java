package Array.medium;

/**
 * @author Kedar Erande
 */
public class MinimumSizeSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (start < nums.length && end < nums.length) {
            sum = sum + nums[end];

            if (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                start++;
                end = start;
                sum = 0;
            } else {
                end++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;


    }

    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        int len = minSubArrayLen(target, nums);
        System.out.println(len);


    }
}
