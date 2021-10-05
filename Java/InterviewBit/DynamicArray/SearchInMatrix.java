package DynamicArray;

/**
 * @author Kedar Erande
 */
public class SearchInMatrix {
    public static void main(String[] args) {

        int A[][] = {

                {1}
        };

        int pos = solve(A, 1);
        System.out.println(pos);

    }

    private static int solve(int matrix[][], int element) {
        if (element < 0) {
            return -1;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (element > matrix[i][matrix[i].length - 1] && matrix[i][matrix[i].length - 1] != 0) {
                i = i + 1;
            }

            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == element) {
                    return (i + 1) * 1009 + (j + 1);
                }

            }
        }

        return -1;
    }
}
