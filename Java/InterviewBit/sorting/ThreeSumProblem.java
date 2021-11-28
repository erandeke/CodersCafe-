package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 * Detailed exp: https://www.youtube.com/watch?v=onLoX6Nhvmg
 * TC : O(n*n) n-> for fixing the a and other n for two pointer approach
 * since we need to calulcate a+b+c=0
 * b+c=-a hence we need to fix a first then by two pointer approach we need to calculate the sum
 */
public class ThreeSumProblem {
    public static void main(String[] args) {

        // int nums[] = {-2, -2, -1, -1, -1, -1, 0, 0, 0, 2, 2, 2};
        int nums[] = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> res = new ThreeSumProblem().generate(nums);
        System.out.println(res);
    }

    public List<List<Integer>> generate(int nums[]) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        //remove duplicates
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
