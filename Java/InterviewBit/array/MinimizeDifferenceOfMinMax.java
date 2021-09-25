package array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Kedar Erande
 */
public class MinimizeDifferenceOfMinMax {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(3);
        list.add(9);
        list.add(8);

        int B = 3;

        System.out.println(solve(list, B));


    }

    public static int solve(ArrayList<Integer> A, int B) {
        //find min and max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
            if (freq.containsKey(A.get(i))) {
                freq.put(A.get(i), A.get(i) + 1);
            } else {
                freq.put(A.get(i), 1);
            }
        }
        int min_diff = max - min;

        while (B > 0 && min_diff != 0) {
            if (freq.get(min) <= freq.get(max)) {
                //increment the frequency
                freq.put(min + 1, freq.getOrDefault(min + 1, 0) + freq.get(min));
                //reduce B operation
                B -= freq.get(min);
                //update new min;
                min = min + 1;
            } else if (freq.get(max) <= freq.get(min)) {
                freq.put(max - 1, freq.getOrDefault(max - 1, 0) + freq.get(max));
                B -= freq.get(max);
                max = max - 1;
            }
            if (B >= 0) {
                min_diff = max - min;
            }
        }

        return min_diff;
    }
}
