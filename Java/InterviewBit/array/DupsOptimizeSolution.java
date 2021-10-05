package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kedar Erande
 * <p>
 * Problem :
 * Given a binary matrix A of integers 0 and 1, of size N x M.
 * <p>
 * Find and return the indices of the rows which are duplicate of rows which are already present in the matrix.
 * <p>
 * If row[i] and row[j] are same and i < j then answer will contain only index j.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right. There will be at least one duplicate row in the matrix.
 * Input 1:
 * A = [   [1, 0, 0]
 * [0, 1, 0]
 * [0, 1, 0]   ]
 * Output 1:
 * [3]
 * <p>
 * TC: O(n)
 */
public class DupsOptimizeSolution {
    public static void main(String[] args) {
        int matrix[][] = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 0, 0}
        };
        returnDups(matrix);
    }

    private static int[] returnDups(int A[][]) {
        ArrayList<Integer> ans = new ArrayList();
        Set<String> setA = new HashSet();

        for (int i = 0; i < A.length; ++i) {
            String str = Arrays.toString(A[i]);
            if (setA.contains(str)) {
                ans.add(i + 1);
            } else {
                setA.add(str);
            }
        }

        System.out.println(setA);
        return ans.stream().mapToInt((ix) -> {
            return ix;
        }).toArray();

    }
}
