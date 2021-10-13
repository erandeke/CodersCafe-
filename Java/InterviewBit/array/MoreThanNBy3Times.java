package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class MoreThanNBy3Times {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 2, 3, 1, 1, 10);
        System.out.println(repeatedNumber(arr));
    }

    public static int repeatedNumber(final List<Integer> a) {

        int repetative = (a.size()) / 3;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            if (freq.containsKey(a.get(i))) {
                freq.put(a.get(i), freq.get(a.get(i)) + 1);
            } else {
                freq.put(a.get(i), 1);
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (freq.get(a.get(i)) > repetative)
                return a.get(i);
        }
        return -1;
    }
}
