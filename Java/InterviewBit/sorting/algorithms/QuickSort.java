package sorting.algorithms;

/**
 * @author Kedar Erande
 * Optimised approach is selecting random pivot
 * complexity is nlogn
 * in place
 * worst case : O(n^2)
 * No stable since swapping is done based upon the pivot and not on index pos
 */
public class QuickSort {
    public static void main(String[] args) {

        int arr[] = {7, 2, 1, 6, 8, 5, 3, 4};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);

        }
    }

    private int partition(int arr[], int start, int end) {
        int pivot = arr[end];
        int pi = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pi];
                arr[pi] = temp;
                pi++;
            }

        }
        int temp = arr[end];
        arr[end] = arr[pi];
        arr[pi] = temp;
        return pi;
    }
}
