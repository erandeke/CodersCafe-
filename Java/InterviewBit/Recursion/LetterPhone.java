package Recursion;

import java.util.*;

/**
 * @author Kedar Erande
 */
public class LetterPhone {
    public static void main(String[] args) {
        ArrayList<String> arrayList = letterCombinations("10");
        System.out.println(arrayList);


    }

    public static ArrayList<String> letterCombinations(String A) {
        ArrayList<String> res = new ArrayList<>();
        Map<Character, String> map = Map.of(
                '0', "0",
                '1', "1",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");
        if (A.isEmpty())
            return res;
        helper(0, A, "", map, res);
        return res;
    }

    static void helper(int idx, String d, String curr, Map<Character, String> map, ArrayList<String> res) {
        if (idx >= d.length()) {
            res.add(curr);
            return;
        }

        String s = map.get(d.charAt(idx));
        for (int i = 0; i < s.length(); i++) {
            String x = curr + String.valueOf(s.charAt(i));
            helper(idx + 1, d, x, map, res);
        }


    }
}



