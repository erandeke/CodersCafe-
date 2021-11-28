package sorting.algorithms;

/**
 * @author Kedar Erande
 * Optimised bubble sort :
 * The above function (normalised bubble sort) always runs O(n^2) time even if the array is sorted.
 * It can be optimized by stopping the algorithm if inner loop didn’t cause any swap.
 */
public class BubbleSort {
    public static void main(String[] args) {

        // int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int arr[] = {1, 2, 3, 4, 5};
        generateSortingBubble(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static int[] generateSortingBubble(int arr[]) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                if (!swapped)
                    break;
            }
        }
        return arr;
    }
}
