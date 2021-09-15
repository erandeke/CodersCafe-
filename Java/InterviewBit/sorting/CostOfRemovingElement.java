package sorting;

import java.util.Arrays;

/**
 * @author Kedar Erande
 *
 * PS:
 * Given an integer array A of size N. In one operation, you can remove any element from the array, and the cost of this operation is the sum of all elements in the array present before this operation.
 *
 * Find the minimum cost to remove all elements from the array.
 *
 * Approach : Remove the max element and sum of the remaning is the minimum what you can get
 *
 * Tc = n^2
 */
public class CostOfRemovingElement {
    public static void main(String[] args) {

        //  int A[] = {3, 6, 4, 2};
       // int A[] = {1, 2};
        int A[] = {5};
        int val = new CostOfRemovingElement().solve(A);
        System.out.println(val);

    }

    public int solve(int[] A) {
        Arrays.sort(A);
        int sum = A[0];
        for (int i = A.length - 1; i >= 1; i--) {
            sum = sum + A[i];
            for (int j = i - 1; j >= 0; j--) {
                sum += A[j];
            }

        }
        return sum;
    }
}
