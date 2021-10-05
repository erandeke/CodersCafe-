package array;

import java.util.Arrays;

/**
 * @author Kedar Erande
 * <p>
 * PS:
 * Maximum Difference
 * Given an array of integers A and an integer B. Find and return the maximum value of | s1 - s2 |
 * <p>
 * where s1 = sum of any subset of size B, s2 = sum of elements of A - sum of elemets of s1
 * <p>
 * Note |x| denotes the absolute value of x.
 * <p>
 * Approach is to find the first window till B as front and last B as Back denote as s1
 * then find s2 such that sum of all n elements - s1 front
 * and s2= sum of all elements - s1-back
 * <p>
 * find the max between these four;
 */
public class MaximumSum {
    public static void main(String[] args) {
        int A[] = {69, 72, 53, 45, 19, 31, 50, 17, 2, 28, 48, 43, 59, 23, 78, 32, 67, 51, 36, 60, 76, 25, 59, 6, 90, 78, 15, 26, 79, 6, 22};
        //int A[] = {5, 17, 100, 11};
        int B = 15;
        System.out.println(maxsum(A, B));
    }

    private static int maxsum(int A[], int B) {

        int s1_front = 0;
        int s1_back = 0;
        int sum = 0;
        Arrays.sort(A);
        int min = 0;
        int max = 0;
        int s2_front = 0;
        int s2_back = 0;

        for (int i = 0; i < B; i++) {
            s1_front += A[i];
            min = s1_front;
        }


        for (int i = A.length - B; i < A.length; i++) {
            s1_back += A[i];
            max = s1_back;
        }


        for (int i = 0; i < A.length; i++) {
            sum += A[i];

        }

        s2_front = sum - min;
        s2_back = sum - max;


        return Math.max(Math.abs(s1_back - s2_back), Math.abs(s1_front - s1_front));

    }

    //Math.max(Math.abs(s1_back-max_diff_back),Math.abs(s1_front-max_diff_front)
}
