package array.medium;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class MergeArrays {
    public static void main(String[] args) {

        List<Integer> A = Arrays.asList(4, 7, 9);
        List<Integer> B = Arrays.asList(2, 11, 19);
        ArrayList<Integer> res = new MergeArrays().mergeTwoArrays(A, B);
        System.out.println(res);

    }


    private ArrayList<Integer> mergeTwoArrays(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = 0;
        int a_size = A.size();
        int b_size = B.size();
        ArrayList<Integer> res = new ArrayList<>();

        while (i < a_size && j < b_size) {
            int a = A.get(i);
            int b = B.get(j);

            if (a > b) {
                res.add(b);
                j++;
            } else {
                res.add(a);
                i++;
            }

        }
        if (i != a_size) {
            mergeRemainingBits(A, res, i);
        } else {
            mergeRemainingBits(B, res, j);
        }

        return res;
    }


    private void mergeRemainingBits(List<Integer> remains, ArrayList<Integer> res, int counter) {
        for (int r = counter; r < remains.size(); r++) {
            res.add(remains.get(r));
        }

    }
}
