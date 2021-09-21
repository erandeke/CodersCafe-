package array;

import java.util.Arrays;

/**
 * @author Kedar Erande
 *
 * PS:
 * You are given an integer array A having N integers.
 *
 * You have to find the minimum length subarray A[l..r] such that sorting this subarray makes the whole array sorted.
 */
public class SortUnsortedArray {
    public static void main(String[] args) {

    }
        public int solve(int[] A) {
            int start_pointer = 0;
            int end_pointer = A.length - 1;

            int copy_arr[] = new int[A.length];

            for (int i = 0; i < A.length; i++) {
                copy_arr[i] = A[i];
            }

            //sort the copy array

            Arrays.sort(copy_arr);

            while (start_pointer <= end_pointer) {

                if (A[start_pointer] == copy_arr[start_pointer]) {
                    start_pointer++;
                } else
                    break;
            }

            if (start_pointer == A.length - 1) {
                return 0;

            }

            while (end_pointer > start_pointer) {
                if (A[end_pointer] == copy_arr[end_pointer]) {
                    end_pointer--;
                } else
                    break;
            }

            return (end_pointer - start_pointer)+1;

        }
    }




