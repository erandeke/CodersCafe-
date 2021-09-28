package array;

/**
 * @author Kedar Erande
 * <p>
 * Brute Force on Non dec array n*m TC
 */
public class NonDecArrayy {

    public static void main(String[] args) {

        // int A[] = {7, 7, 1, 6, 9};
        int A[] = {1, 7, 3, 4, 9};
        /*int B[][] = {

                {1, 3},
                {4, 5},
                {1, 2},
                {3, 4},
                {1, 5}
        };*/
        int B[][] = {
                {1, 2},
                {2, 4}
        };
        int ans[] = new NonDecArrayy().solve(A, B);
        for (int i : ans) {
            System.out.println(i);
        }

    }

    public int[] solve(int[] A, int[][] B) {
        //initialize the result array with the length of B queries
        int result[] = new int[B.length];
        //Use bit mask for raising bit as 1 if non decrementing and 0 as decrementing
        int bit_mask[] = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            result[i] = 1;
        }

        //for the first case
        if (A[0] <= A[1]) {
            bit_mask[0] = 1;
        } else {
            bit_mask[0] = 0;
        }

        //from comparing second to n
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                bit_mask[i + 1] = 1;
            } else {
                bit_mask[i + 1] = 0;
            }
        }

        for (int j = 0; j < B.length; j++) {
            //get the queries inside C object
            int C[] = B[j];
            //since we are dealing with 0 based indexing  reduce the start by 1 and end by 1
            int start = C[0] - 1;
            int end = C[C.length - 1] - 1;
            //traverse the queries such that start should start+1 since we donot have to condier beginning element
            //as it also the part of previous pair and might be broken or non decrementing
            for (int k = start + 1; k <= end; k++) {
                if (bit_mask[k] == 0) {
                    result[j] = 0;
                }
            }

        }

        return result;
    }
}
