package array;

/**
 * @author Kedar Erande
 */
public class XorQueriesSolution {
    public static void main(String[] args) {
        int A[] = {1, 0, 0, 0, 1};
        int B[][] = {
                {2, 4},
                {1, 5},
                {3, 5}

        };
        solve(A, B);
    }

    private static int[][] solve(int A[], int B[][]) {
        int matrix[][] = new int[B.length][2];

        int prefixsum[] = new int[A.length + 1];
        prefixsum[0] = A[0];

        for (int i = 0; i < A.length; i++) {
            prefixsum[i + 1] = prefixsum[i + 1] + prefixsum[i];
            prefixsum[i + 1] = prefixsum[i + 1] + A[i];

        }

        for (int i = 0; i < B.length; i++) {
            //find the xor for the query given
            int l = B[i][0];
            int r = B[i][1];
            int length = r - l + 1;
            int sum = 0;
            int ans = 0;
            sum = prefixsum[r] - prefixsum[l - 1];
            ans = length - sum;
            matrix[i][1] = ans;
            if (sum % 2 != 0) {
                matrix[i][0] = 1;
            } else {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
