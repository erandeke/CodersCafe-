package array;

/**
 * @author Kedar Erande
 */
public class XORQueries {
    public static void main(String[] args) {
        int A[] = {1, 0, 0, 0, 1};
        int B[][] = {
                {2, 4},
                {1, 5},
                {3, 5}

        };

        int result[][] = getTheXorQueries(A, B);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }


    }

    private static int[][] getTheXorQueries(int A[], int queries[][]) {

        int matrix[][] = new int[queries.length][2];
        int prefix_sum[] = new int[A.length];
        prefix_sum[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            prefix_sum[i] = prefix_sum[i - 1] + A[i];
        }

        for (int i = 0; i < queries.length; i++) {
            //find the xor for the query given
            int l = queries[i][0] - 1;
            int r = queries[i][1] - 1;
            int length = r - l + 1;
            int xorVal = 0;
            //compute no of zeros inside prefix sum array
            int sum = 0;
            int ans = 0;
            if (l == 0) {
                length = r - l;
                sum = prefix_sum[r] - prefix_sum[l + 1];
                ans = length - sum;
                matrix[i][1] = ans;
            } else {

                sum = prefix_sum[r] - prefix_sum[l];
                ans = length - sum;
                matrix[i][1] = ans;
            }
            xorVal = A[r] - A[l];
            if (xorVal % 2 != 0)
                matrix[i][0] = 1;
            else
                matrix[i][0] = 0;

        }

        return matrix;
    }
}
