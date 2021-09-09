package array;

/**
 * @author Kedar Erande
 *
 * Problem Statement : Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 *
 * Input :  A = [0 1 2 0 1 2]
 * OP:   [0 0 1 1 2 2]
 * Exta space : O(n)
 * Tc : O(n)
 */

public class SortByColor {

    public static void main(String[] args) {

        int A[] = {01,1,2,0,1,2};
        int B[] = new SortByColor().sortColors(A);
        //print array

    }

    public int[] sortColors(int[] A) {
        int B[] = new int[A.length];
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        //count number of ocurrences for 0, 1, 2
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                countZero += 1;
            }
            if (A[i] == 1) {
                countOne += 1;
            }
            if (A[i] == 2) {
                countTwo += 1;
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (i < countZero) {
                B[i] = 0;
            } else if (i < countOne + countZero) {
                B[i] = 1;
            } else if (i < countOne + countTwo + countZero) {
                B[i] = 2;
            }
        }
        return B;
    }
}
