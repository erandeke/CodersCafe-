package recursion.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class Reverse {

    public static void reverseString(char[] s) {
        List<String> res = new ArrayList<>();
        performReverseOps(0, s.length - 1, s[s.length - 1], res, s);
        System.out.println(res);

    }

    public static void performReverseOps(int counter, int idx, char c, List<String> list, char[] s) {
        if (counter == s.length)
            return;
        list.add(String.valueOf(c));
        counter = counter + 1;
        idx = idx - 1;
        if (idx >= 0) {
            performReverseOps(counter, idx, s[idx], list, s);
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);

    }
}
