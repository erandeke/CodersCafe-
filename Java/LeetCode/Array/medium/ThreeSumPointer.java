package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class ThreeSumPointer {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                low = i + 1;
                high = nums.length - 1;
                sum = 0 - nums[i];
            }

            while (low < high) {

                if (nums[low] + nums[high] == sum) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    while (low < high && nums[low] == nums[low + 1])
                        low++;
                    while (low < high && nums[high] == nums[high - 1])
                        high--;
                } else {
                    if (nums[low] + nums[high] < sum) //since we have sorted in order to reach to the sum low++
                        low++;
                    else
                        high--; //that mean sum is too large and since we have sorted we need to high-- to get to the sum
                }
                low++;
                high--;

            }
        }

        return res;
    }

    public static void main(String[] args) {
        ThreeSumPointer ts = new ThreeSumPointer();
        int nums[] = {1, -1, -1, 0};
        //-1 -1 0 1
        ts.threeSum(nums);
    }
}
