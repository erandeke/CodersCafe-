package sorting;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Kedar Erande
 */
public class MinIncrementArrayBruteForce {

    public static void main(String[] args) {
        //int nums[] = {3, 2, 1, 2, 1, 7};
        int nums[] = {1, 1, 2};
        int x = new MinIncrementArrayBruteForce().findMinimumSteps(nums);
        System.out.println(x);

    }

    private int findMinimumSteps(int nums[]) {
        HashSet<Integer> has = new HashSet<>();
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            has.add(nums[i]);
        }

        for (int i = 1; i < nums.length; i++) {
            int minSteps = 0;
            int counter = 0;
            if (nums[i] == nums[i - 1]) {
                minSteps = minSteps + nums[i];
                ans = ans + isValuePresent(has, minSteps, counter);

            }
        }
        return ans;

    }


    private int isValuePresent(HashSet<Integer> hashSet, int minSteps, int counter) {
        if (!hashSet.contains(minSteps)) {
            hashSet.add(minSteps);
            return counter;
        } else {
            minSteps = minSteps + 1;
            counter++;
            return isValuePresent(hashSet, minSteps, counter);
        }
    }


}
