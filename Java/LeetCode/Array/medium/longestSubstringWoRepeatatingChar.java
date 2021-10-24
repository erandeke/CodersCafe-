package Array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class longestSubstringWoRepeatatingChar {
    public static void main(String[] args) {
        System.out.println(getThelongestSubstring("pwwkew"));
    }

    private static int getThelongestSubstring(String str) {
        int n = str.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(str.charAt(j))) {
                i = Math.max(map.get(str.charAt(j)), i);// here i will max of i and j+1 since substring from [i j] is already
                //visited
            }   
            ans = Math.max(ans, j - i + 1); //the length betweeen range i and j
            map.put(str.charAt(j), j + 1);//store the characters at their index
        }
        return ans;

    }
}
