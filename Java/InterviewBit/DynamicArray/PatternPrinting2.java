package DynamicArray;

/**
 * @author Kedar Erande
 */
public class PatternPrinting2 {
    public static void main(String[] args) {

        int B[][] = PatternPrinting2.solve(3);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                System.out.println(B[i][j] + " ");
            }
        }

    }

    public static int[][] solve(int A) {
        int arr[][] = new int[A][A];
        int K = 0;
        int i = 0;
        for (i = 0; i < A; i++) {
            K = 0;
            for (int j = A - 1; j >= 0; j--) {
                if (arr.length - 1 - i <= j) {
                    K = K + 1;
                    arr[i][j] = K;
                } else {
                    arr[i][j] = 0;
                }
            }
        }
        return arr;
    }
}
