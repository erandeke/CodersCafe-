package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 * <p>
 * PS: Given a positive integer A. Return an array of minimum length whose elements represent the powers of 3 and the sum of all the elements is equal to A.
 * <p>
 * Approach : We need to divide the number by 3 such that the quotient turns out to be 0 .
 * Then we need to find how many times the number is at that position
 * for example :
 * 14-> 2*3^0 + 1*3(1) + 1*3(2) --> so ans will be 1,1,3,9
 * TC : logbase3
 */
public class PowerOf3 {
    public static void main(String[] args) {

        int arr[] = computePowerOfThree(411);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int[] computePowerOfThree(int A) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int R = 0;
        while (A != 0) {
            R = A % 3;
            A = A / 3;
            while (R != 0) {
                list.add((int) (Math.pow(3, i)));
                R--;
            }
            i++;

        }
        int arr[] = list.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}
