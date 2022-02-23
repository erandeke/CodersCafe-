package slidingWindow;

/**
 * @author Kedar Erande
 *
 * LC: https://leetcode.com/problems/max-consecutive-ones-iii/submissions/
 * slide the window till u find 0 once the k is exhausted that means time to increase start
 * if start is 0 then increase k value
 * then ans : end - start
 */
public class MaxConsectiveOnes {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;

        while(end < nums.length)
        {

            if(nums[end] == 0)
                k--;
            if(k < 0)
            {
                if(nums[start]==0)
                {
                    k++;
                }

                start++;
            }
            end++;

        }
        return end-start;
    }
}
