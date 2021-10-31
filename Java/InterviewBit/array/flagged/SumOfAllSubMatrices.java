package array.flagged;

/**
 * @author Kedar Erande
 * This is working but need to understand the approach
 */
public class SumOfAllSubMatrices {
    public static void main(String[] args) {

    }

    public int solve(int[][] A) {
        int sum = 0;
        int n = A.length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                int tl = (i + 1) * (j + 1);
                int br = (n - i) * (n - j);
                int totalSubMatricesCount = tl * br;
                sum = sum + (totalSubMatricesCount * A[i][j]);
            }
        }

        return sum;
    }
}
