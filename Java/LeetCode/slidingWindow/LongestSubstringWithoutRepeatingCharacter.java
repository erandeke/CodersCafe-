package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {

        //String s = "abcabcbb";
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = Integer.MIN_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);


            if (map.size() == end - start + 1) {
                len = Math.max(len, end - start + 1);
                end++;
            } else if (map.size() < end - start + 1) {
                //we have the duplicates
                while (map.size() < end - start + 1) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                    if (map.get(s.charAt(start)) == 0) {
                        map.remove(s.charAt(start));
                    }
                    start++;
                }
                end++;
            }

        }
        return len;
    }
}
