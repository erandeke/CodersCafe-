package array;

/**
 * @author Kedar Erande
 * <p>
 * PS: Find the least average subArray of size K
 * AP: take  the sum of elememts till first window K .Mark it as minimum
 * from K to n - do these 1)take sum of incoming elenent in subarray
 * 2)Then reduce sum of outgoing element that is i-k element
 * 3)ompare min sum
 */
public class LeastSubArrayAverage {
    public static void main(String[] args) {

        // int A[] = {3, 7, 5, 20, -10, 0, 12};
        // int A[] = {5, 15, 7, 6, 3, 4, 18, 14, 13, 7, 3, 7, 2, 18};
        int A[] = {3, 7, 5, 20, -10, 0, 12};
        System.out.println(getLeastSubArrayIndex(A, 2));
    }

    private static int getLeastSubArrayIndex(int A[], int K) {
        int min_index = 0;
        int sum = 0;
        int min_sum = Integer.MAX_VALUE;

        for (int i = 0; i < K; i++) {
            sum += A[i];

        }

        min_sum = Math.min(min_sum, sum);

        for (int i = K; i < A.length; i++) {
            sum += A[i];
            sum -= A[i - K];
            if (min_sum > sum) {
                min_sum = sum;
                min_index = i - K + 1;
            }
        }
        return min_index;
    }
}
