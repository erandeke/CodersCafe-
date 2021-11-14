package Recursion;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class ParenthesisII {
    public static void main(String[] args) {

        ArrayList<String> arr = generateParenthesis(3);
        System.out.println(arr);
    }

    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), n, n, n);
        return ans;
    }

    public static void backtrack(ArrayList<String> ans, StringBuilder cur, int open, int close, int max) {
        if (open == 0 && close == 0) {
            ans.add(cur.toString());
            return;
        }

        if (open > 0) {
            cur.append("(");
            backtrack(ans, cur, open - 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close > open) {
            cur.append(")");
            backtrack(ans, cur, open, close - 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }


    }
}
