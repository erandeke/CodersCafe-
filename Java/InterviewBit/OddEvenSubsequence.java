/**
 * @author Kedar Erande
 */

/*

Given an array of integers A of size N. Find the longest subsequence of A which is odd-even.

A subsequence is said to odd-even in the following cases:

The first element of the subsequence is odd, second element is even, third element is odd and so on. For example: [5, 10, 5, 2, 1, 4], [1, 2, 3, 4, 5]

Input 1:
    A = [1, 2, 2, 5, 6]
Output 1:
    4
    Explanation 1:
    Maximum length odd even subsequence is [1, 2, 5, 6]

Expected Time Complexity : O(n)


 */

public class OddEvenSubsequence {
    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 5, 6};
        int val = new OddEvenSubsequence().solve(arr);
    }


    public int solve(int[] A) {
        String odd_counter = "ON";
        String even_counter = "ON";
        int odd_even = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0 && odd_counter == "ON") {
                odd_even = odd_even + 1;
                odd_counter = "OFF";
                even_counter = "ON";
            } else if (A[i] % 2 == 0 && even_counter == "ON") {
                odd_even = odd_even + 1;
                even_counter = "OFF";
                odd_counter = "ON";
            }
        }

        return odd_even;


    }
}
