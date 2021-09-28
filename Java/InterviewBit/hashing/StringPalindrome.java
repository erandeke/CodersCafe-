package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 */
public class StringPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        int palindrome = solve(str);
        System.out.println(palindrome);

    }

    private static int solve(String str) {
        char A[] = str.toCharArray();
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : A) {
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }

        int evenpalindrome = 1;
        int oddpalindrome = 1;
        for (Map.Entry<Character, Integer> map : freq.entrySet()) {
            if (map.getValue() % 2 != 0) {
                if (oddpalindrome == 1) {
                    oddpalindrome--;
                } else {
                    evenpalindrome = 0;
                    break;
                }
            }
        }
        return evenpalindrome;

    }
}
