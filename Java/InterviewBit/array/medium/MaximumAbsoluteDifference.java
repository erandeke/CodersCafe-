package array.medium;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class MaximumAbsoluteDifference {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
      /*  arr.add(3);
        arr.add(-2);
        arr.add(5);
        arr.add(-4);*/
        arr.add(1);
        arr.add(3);
        arr.add(-1);
        System.out.println(maxArr(arr));

    }

    public static int maxArr(ArrayList<Integer> A) {
        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int res_cand_1 = 0;

        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int res_cand_2 = 0;
        int result = 0;

        for (int i = 1; i <= A.size(); i++) {

            res_cand_1 = checkWithEquationWheniIsGreaterThanj(A.get(i - 1), i);
            max1 = Math.max(max1, res_cand_1);
            min1 = Math.min(res_cand_1, min1);

            res_cand_2 = checkWithEquationWheniIsLesserThanj(A.get(i - 1), i);
            max2 = Math.max(max2, res_cand_2);
            min2 = Math.min(res_cand_2, min2);

        }

        result = Math.max((max1 - min1), (max2 - min2));

        return result;

    }


    private static int checkWithEquationWheniIsGreaterThanj(int value, int index) {
        return value + index;
    }

    private static int checkWithEquationWheniIsLesserThanj(int value, int index) {
        return value - index;
    }
}
