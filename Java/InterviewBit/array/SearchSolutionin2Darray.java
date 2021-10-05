package array;

/**
 * @author Kedar Erande
 * <p>
 * TC : O(n+m)
 * This can also accepted as n*m since the 1<n , m<=1000
 */
public class SearchSolutionin2Darray {
    public static void main(String[] args) {

        int A[][] = {

                {1, 2, 2},
                {4, 5, 6},
                {7, 8, 9}
        };

        int pos = new SearchSolutionin2Darray().solve(A, 2);
        System.out.println(pos);
    }

    public int solve(int[][] A, int B) {
        int i = 0, j = A[0].length - 1;
        int pos = Integer.MAX_VALUE;
        boolean got = false;


        while (i < A.length && j >= 0) {

            if (A[i][j] == B) {
                pos = Math.min(pos, (i + 1) * 1009 + (j + 1));
                got = true;
                j--;
            } else if (A[i][j] > B) {

                j--;

            } else

                i++;


        }
        if (got) {
            return pos;
        }

        return -1;
    }
}
