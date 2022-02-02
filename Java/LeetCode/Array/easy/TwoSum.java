package Array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class TwoSum {

    //Time complexity : O(n)
    //Space Complexity : O(n) -> we need Hash Map to store the element and indices

    public static int[] twoSum(int[] nums, int target) {

        int result[] = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int k = 0; k < nums.length; k++) {
            if (map.containsKey(target - nums[k])) {
                result[1] = k; //end index of the caught number
                result[0] = map.get(target - nums[k]); //begin index of the target-nums[k];
                break;
            } else {
                map.put(nums[k], k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // int nums[] = {2, 7, 11, 15};
        // int target = 9;
        int nums[] = {3, 2, 4};
        int target = 6;
        int result[] = TwoSum.twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
