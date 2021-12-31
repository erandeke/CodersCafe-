package slidingWindow;

/**
 * @author Kedar Erande
 * //This is the sliding window algorithm where the problem is asked to find the maximum sum of subarray with size k
 */
public class MaxSumSubArraySizeK {
    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 4, 1, 1, 2};
        int k = 3;
        int sum = maxSum(nums, k);
        System.out.println(sum);
    }

    private static int maxSum(int nums[], int K) {
        int sum = 0;
        int maxSum = 0;
        int i = 0;
        int j = 0;
        int size = nums.length;
        while (j < size) {
            sum += nums[j];
            if (j - i + 1 == K) //this means we have hit the window now calculate the max sum of that subarray
            {
                maxSum = Math.max(sum, maxSum);
                //now inorder to maintain the window state
                /*
                1)Increase i pointer
                2)Increase j pointer
                3)decrease the ith element from the sum so that jth next elemment of next window can be added to the sum
                 */
                sum = sum - nums[i];
                i++;
                j++;
            } else {
                j++;
            }
        }

        return maxSum;

    }
}
