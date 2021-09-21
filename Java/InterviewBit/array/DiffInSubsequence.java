package array;

import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class DiffInSubsequence {
    public static void main(String[] args) {

        int A[] = {1, 3, 2, 5, 7};
        System.out.println(getSum(A));

    }

    private static int getSum(int A[]) {
        int max = 0;
        int min = 0;
        int n = A.length;
        Arrays.sort(A);

        for (int i = 0; i < n; i++) {
            max += Math.pow(2, i) * A[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            min += Math.pow(2, n - i - 1) * A[i];
        }

        return max - min;
    }
}
