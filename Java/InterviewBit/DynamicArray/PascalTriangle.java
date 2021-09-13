package DynamicArray;

/**
 * @author Kedar Erande
 * nCr formula - choose the r objects from n objects in such way that n!/r!*(n-r)!
 * <p>
 * <p>
 * Formula suggest by TA : arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int A = 3;
        int B[][] = new PascalTriangle().solve(A);
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                System.out.println(B[i][j] + " ");
            }
        }

    }

    public int[][] solve(int A) {
        int arr[][] = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i][j] = 1;
            }
        }
        for (int i = 2; i < A; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }

        return arr;
    }


}
