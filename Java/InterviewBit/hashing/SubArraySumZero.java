package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Kedar Erande
 *
 * Problem : SubArray with sum 0
 * Problem Statement : Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1 else return 0.
 *
 * Approach here is to calculate the prefix sum and check if that is present in map or equals to 0
 * TC : O(n)
 */
public class SubArraySumZero {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(-3);
        arr.add(1);
        arr.add(3);
        System.out.println(solve(arr));

    }

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int prefix_sum = 0;

        for (int i = 0; i < A.size(); i++) {
            prefix_sum += A.get(i);
            if (prefix_sum == 0) {
                return 1;
            }
            if (hashMap.containsKey(prefix_sum)) {
                return 1;
            } else {
                hashMap.put(prefix_sum, 1);
            }
        }

        return 0;
    }
}
