package array;

/**
 * @author Kedar Erande
 *
 * Problem desc: Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.
 *
 * Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.
 *
 * A = [1, 2, 3, 4, 5]
 *     B = [2, 3]
 *     OP:
 *
 *
 * TC : d*n
 */
public class MultipleLeftRotations {
    public static void main(String[] args) {

        int A[] = {1, 2, 3, 4, 5};
        int B[] = {1};
        int temp[][] = solve(A, B);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                System.out.println(temp[i][j]);
            }
        }
    }

    public static int[][] solve(int[] A, int[] B) {
        int temp[][] = new int[B.length][A.length];

        for (int i = 0; i < B.length; i++) {
            int d = B[i];
            int mod = d % A.length;
            for (int j = 0; j < A.length; j++) {
                int element = (j + mod) % A.length;
                temp[i][j] = A[element];
            }
        }


        return temp;
    }
}
