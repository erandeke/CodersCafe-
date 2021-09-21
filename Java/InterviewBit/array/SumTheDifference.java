package array;

import java.util.Arrays;

/**
 * @author Kedar Erande
 *
 * PS:
 * Given an integer array A of size N.
 * You have to find all possible non-empty subsequence of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence Then add up all the differences to get the number.
 *
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 *
 * Approach : https://www.geeksforgeeks.org/find-sum-maximum-difference-possible-subset-given-array/
 */
public class SumTheDifference {
    public static void main(String[] args) {

    }

    public int solve(int[] A) {
        Arrays.sort(A);

        int max=0,min=0,mod=(int)(1e9+7);

        for(int i=0;i<A.length;i++){

            max=2*max+A[A.length-1-i];

            max=max%mod;

            min=2*min+A[i];

            min=min%mod;

        }

        return (max%mod-min%mod + mod)%mod;
    }
}
