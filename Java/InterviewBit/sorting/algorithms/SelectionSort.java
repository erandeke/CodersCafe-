package sorting.algorithms;

/**
 * @author Kedar Erande
 * Selection sort : https://www.geeksforgeeks.org/selection-sort/
 * Time Complexity: O(n2) as there are two nested loops.
 * Auxiliary Space: O(1)
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 *
 */
public class SelectionSort {
    public static void main(String[] args) {

        int arr[] = {64, 25, 12, 22, 11};
        performSelectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static int[] performSelectionSort(int arr[]) {
        int min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
        return arr;
    }
}
