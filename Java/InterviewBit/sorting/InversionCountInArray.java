package sorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class InversionCountInArray {
    public static void main(String[] args) {
        int arr[] = {3, 2, 1};
        System.out.println(new InversionCountInArray().solve(arr));
    }

    public int solve(int arr[]) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int arr[], int l,
                                         int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        long count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count = (long) ((count + (mergeSortAndCount(arr, l, m))) % (1e9 + 7));

            // Right subarray count
            count = (long) ((count + mergeSortAndCount(arr, m + 1, r)) % (1e9 + 7));

            // Merge count
            count = (long) ((count + mergeAndCount(arr, l, m, r)) % (1e9 + 7));
        }

        return (int) (count);
    }

    private static int mergeAndCount(int[] arr, int l,
                                     int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

}
