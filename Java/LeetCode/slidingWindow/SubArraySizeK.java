package slidingWindow;

/**
 * @author Kedar Erande
 */
public class SubArraySizeK {
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (end < arr.length) {
            sum = sum + arr[end];

            if ((end - start + 1) == k) {
                if ((sum / k) >= threshold) {
                    count++;
                }

                sum = sum - arr[start];
                start++;
                end++;
            } else {
                end++;
            }


        }
        return count;

    }

    public static void main(String[] args) {
        int arr[] = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println( numOfSubarrays(arr, k, threshold));

    }
}
