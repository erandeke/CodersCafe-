package array.medium;

/**
 * @author Kedar Erande
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).
 *
 * Find the minimum number of swaps required to sort the array in ascending order.
 *
 * Sort the array and count the minimum no pf swaps:
 * Approach here is : need to check if every element is there at its correct index position or not
 * if yes then move ahead otherwise fix that element to its correct pos .
 * TC : O(n)
 */
public class MinimumSwap2 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 0, 2};
       // int arr[] = {1, 2, 3, 4, 0};
        System.out.println(getMinimumSwaps(arr));
    }

    private static int getMinimumSwaps(int arr[]) {
        int swaps = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {

            while (arr[i] != i) {
                temp = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        return swaps;
    }

}
