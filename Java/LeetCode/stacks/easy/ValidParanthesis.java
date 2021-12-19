package stacks.easy;

import java.util.Stack;

/**
 * @author Kedar Erande
 */
public class ValidParanthesis {
    public static void main(String[] args) {

        String str = "({[]})";
        boolean value = isValid(str);
        System.out.println(value);
    }

    private static boolean isValid(String s) {
        Stack<Character> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty())
                    return false;
                char c = st.peek();
                st.pop();
                if ((s.charAt(i) == ')' && c == '(') || (s.charAt(i) == '}' && c == '{') || (s.charAt(i) == ']' && c == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (st.isEmpty())
            return true;

        return false;
    }
}
