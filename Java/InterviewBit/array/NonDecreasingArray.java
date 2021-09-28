package array;

/**
 * @author Kedar Erande
 *
 * Optmize Approach on Non decreasing array TC: O(n)
 *
 * 1) construct a new array of length n , named as Arr[n] ,
 *
 * 2) Arr[i] will store 1 if A[i]>A[i+1] else it will store 0
 *
 * this is because you only need one decreasing pair which break the condition of non-decreasing subarray
 *
 * 3)then you can use prefix array to store count of 1 ,as pre[i] will store how many times 1 occurs from 0 to ith index.
 *
 * 4) for answering query you just need to subtract pre[R]-pre[L] if it is 0 i.e the subarray is non-decreasing else it has atleast one pair which violates the condition
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int A[] = {7, 7, 1, 6, 9};
        int B[][] = {

                {1, 3},
                {4, 5},
                {1, 2},
                {3, 4},
                {1, 5}
        };
        System.out.println(B.length);
        new NonDecreasingArray().solve(A, B);
    }

    // 1,7,3,6,1
    public int[] solve(int[] A, int[][] B) {
        int bits[] = new int[A.length];
        int result[] = new int[B.length];
        //found the breaking pair
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                bits[i + 1] = 1;
            }
        }
        //prefix array to store the count of 1's

        int pfsum[] = new int[bits.length];

        for (int i = 1; i < bits.length; i++) {
            pfsum[i] = pfsum[i - 1] + bits[i];
        }
        for (int i = 0; i < B.length; i++) {
            int l = B[i][0];
            int r = B[i][1];
            int l_pos = l - 1;
            int r_pos = r - 1;
            //if the sum is 0 that means non decreasing
            if (pfsum[r_pos] - pfsum[l_pos] == 0) {
                result[i] = 1;
            } else {
                result[i] = 0;
            }

        }
        return result;
    }
}
