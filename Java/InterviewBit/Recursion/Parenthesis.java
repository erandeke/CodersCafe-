package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class Parenthesis {
    public static void main(String[] args) {

        ArrayList<String> arr = generateParenthesis(3);
        System.out.println(arr);
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(ArrayList<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }


    }


}