package array;

/**
 * @author Kedar Erande
 *
 * PS: Given an integer array A of size N.
 *You can pick B elements from either left or right end of the array A to get maximum sum.
 *Find and return this maximum possible sum.
 *NOTE: Suppose B = 4 and array A contains 10 elements then
 *You can pick first four elements or can pick last four elements or can pick 1 from front and 3 from back etc .
 * you need to return the maximum possible sum of elements you can pick.
 *
 * TC: O(n)
 *
 * tarverse left remove from left add from right - Approach
 */
public class MaxSumPickElement {
    public static void main(String[] args) {
        // int A[] = {5, -2, 3, 1, 2};
        int A[] = {5, 3, 4, -1, -2, 11, 4, 10, -11, 2, 6, 5, 7, 9, 8};
        int B = 4;
        System.out.println(new MaxSumPickElement().solve(A, B));
    }

    public int solve(int[] A, int B) {
        int leftSum = 0;
        int max = 0;
        int rightSum = 0;
        int leftPointer = B - 1;
        int rightPointer = A.length - 1;

        for (int i = 0; i <= B - 1; i++) {
            max = max + A[i];
        }
        leftSum = max;
        while (leftPointer >= 0) {
            leftSum = leftSum - A[leftPointer];
            leftPointer--;
            rightSum = rightSum + A[rightPointer];
            rightPointer--;
            max = Math.max(max, leftSum + rightSum);
        }

        return max;
    }
}
