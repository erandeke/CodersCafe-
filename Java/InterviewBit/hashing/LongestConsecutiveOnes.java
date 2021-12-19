package hashing;

import java.util.HashSet;

/**
 * @author Kedar Erande
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *  TC : o(n)
 *
 */
public class LongestConsecutiveOnes {
    public static void main(String[] args) {

        int arr[] = {100, 4, 200, 1, 3, 2};
        System.out.println(longestCosecutive(arr));
    }

    private static int longestCosecutive(int arr[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        int longestStreak = 0;

        for (int i = 0; i < arr.length; i++) {
            if (!hs.contains(arr[i] - 1)) {
                int currNum = arr[i];
                int currentStreak = 1;

                while (hs.contains(currNum + 1)) {
                    currNum = currNum + 1;
                    currentStreak = currentStreak + 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
