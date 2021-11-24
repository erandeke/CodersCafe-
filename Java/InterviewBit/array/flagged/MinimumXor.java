package array.flagged;

import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class MinimumXor {
    public static void main(String[] args) {
        int A[] = {12, 4, 6, 2};
        System.out.println(findMinXor(A));
    }

    public static int findMinXor(int[] A) {
        Arrays.sort(A);
        int xor = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            xor = A[i] ^ A[i + 1];
            if (min > xor) {
                min = xor;
            }
        }

        return min;

    }
}
