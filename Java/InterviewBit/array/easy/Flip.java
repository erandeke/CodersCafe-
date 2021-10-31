package array.easy;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 *
 *
 * Problem:
 * You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.
 *
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 *
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 *
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 *
 * TC : O(n)
 *
 */
public class Flip {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int arr[] = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            int p = Integer.valueOf(String.valueOf(c));
            arr[i] = p;
        }
        int l = 0;
        int curr = 0;
        int lmax = -1;
        int rmax = -1;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                curr++;
            } else {
                curr--;
            }
            if (curr > max) {
                max = curr;
                lmax = l;
                rmax = i;
            }
            if (curr < 0) {
                curr = 0;
                l = i + 1;
            }

        }
        if (lmax != -1 && rmax != -1) {
            arrayList.add(lmax + 1);
            arrayList.add(rmax + 1);
        }
        return arrayList;
    }
}
