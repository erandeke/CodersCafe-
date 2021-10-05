package strings;

import java.util.HashMap;

/**
 * @author Kedar Erande
 * //Given a string A of size N consisting of lowercase alphabets.
 *
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 *
 * Find the minimum number of distinct characters in the resulting string.
 *
 * TC : O(n)
 * Example : A = "abcabbccd"
 * Op : bbcbbbccb
 */
public class ChangeChracater {
    public static void main(String[] args) {

        System.out.println(solve("abcabbccd", 3));
    }

    private static int solve(String A, int B) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            Character c = A.charAt(i);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) + 1);
            } else {
                freqMap.put(c, 1);
            }
        }


        while (B > 0) {
            Character charWithMaxValue = freqMap.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

            Character charWithMinValue = freqMap.entrySet().stream().min((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1).get().getKey();

            if (freqMap.get(charWithMinValue) <= B) {
                B -= freqMap.get(charWithMinValue);
                freqMap.put(charWithMaxValue, freqMap.get(charWithMaxValue) + freqMap.get(charWithMinValue));
                freqMap.remove(charWithMinValue);
            } else {
                break;

            }
        }

        return freqMap.size();
    }
}
