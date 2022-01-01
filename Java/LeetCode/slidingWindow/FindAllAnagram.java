package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class FindAllAnagram {
    public static void main(String[] args) {
        // String s = "aabaabaa";
        //String p = "aaba";
        String s = "cbaebacbacd";
        String p = "abc";
        List<Integer> ans = findAllAnagrams(s, p);
        System.out.println(ans);

    }

    private static List<Integer> findAllAnagrams(String s, String p) {
        int start_pointer = 0;
        int end_pointer = 0;
        int window_size = p.length();
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < window_size; i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int counter = hashMap.size();
        while (end_pointer < s.length()) {
            char c = s.charAt(end_pointer);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) - 1);
                if (hashMap.get(c) == 0) {
                    counter--;
                }
            }

            end_pointer++;
            //start sliding preparation
            while (counter == 0) {
                char t = s.charAt(start_pointer);
                if (hashMap.containsKey(t)) {
                    hashMap.put(t, hashMap.get(t) + 1);
                    if (hashMap.get(t) > 0) {
                        counter++;
                    }
                }
                if (end_pointer - start_pointer == window_size) {
                    result.add(start_pointer);
                }
                start_pointer++;

            }

        }
        return result;
    }
}
