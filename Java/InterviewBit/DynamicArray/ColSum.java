package DynamicArray;

/**
 * @author Kedar Erande
 *
 * TC : m*n this is column wise sum
 */
public class ColSum {
    public static void main(String[] args) {

        int B[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 2, 3, 4}
        };
        int res[] = solve(B);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] solve(int B[][]) {
        int col_size = B[0].length;
        int res[] = new int[col_size];

        for (int j = 0; j < col_size; j++) {
            int sum = 0;
            for (int i = 0; i < B.length; i++) {
                sum += B[i][j];

            }
            res[j] = sum;
        }
        return res;
    }
}
