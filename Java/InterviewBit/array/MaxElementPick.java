package array;

/**
 * @author Kedar Erande
 */
public class MaxElementPick {
    public static void main(String[] args) {

        int A[] = {5, -2, 3, 1, 2};
        System.out.println(new MaxElementPick().solve(A, 3));

    }

    public int solve(int[] A, int B) {
        int res = 0;
        for (int i = 0; i < B; i++) {
            res += A[i];
        }
        int lsum = res, rsum = 0, idx = B - 1, i = A.length - 1;
        while (idx >= 0) {
            rsum += A[i];
            lsum -= A[idx];
            res = Math.max(lsum + rsum, res);
            idx--;
            i--;
        }
        return res;
    }
}