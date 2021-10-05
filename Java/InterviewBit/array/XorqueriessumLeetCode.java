package array;

/**
 * @author Kedar Erande
 */
public class XorqueriessumLeetCode {
    public static void main(String[] args) {
        int A[] = {1, 0, 0, 0, 1};
        int B[][] = {
                {2, 4},
                {1, 5},
                {3, 5}

        };

        int result[] = xorQueries(A, B);

    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int len = arr.length;
        int len2 = queries.length;
        int[] ans = new int[len2];
        int[] prefix = new int[len];
        prefix[0] = arr[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        for (int i = 0; i < len2; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (queries[i][0] == 0)
                ans[i] = prefix[queries[i][1]];
            else
                ans[i] = prefix[r - 1] ^ prefix[l - 1];
        }

        return ans;


    }
}
