package array.medium;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 * <p>
 * PS: You are given a binary string A(i.e. with characters 0 and 1) consisting of characters A1, A2, ..., AN. In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters AL, AL+1, ..., AR. By flipping, we mean change character 0 to 1 and vice-versa.
 * <p>
 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
 * <p>
 * If you don't want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.
 * <p>
 * NOTE: Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == c and b < d.
 * <p>
 * Example : 110010011
 * Approach : keep the count of max 0 ;s since those are the ones who will contribute to thr answer
 */
public class FlipFlopGoodSolution {
    public static void main(String[] args) {
        String A = "1101010001";
        ArrayList<Integer> arrayList = flip(A);
        System.out.println(arrayList);

    }

    public static ArrayList<Integer> flip(String A) {
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
            if (arr[i] == 0) { //if we encounter 0 then increase the current count else decrease
                curr++;
            } else {
                curr--;
            }
            if (curr > max) { // if current becomes greater than max then max to curr that also means leftmax
                //that we  have found should be best ones so assign it to l(starting point of subarray
                //and rmax to the i'th index that we are traversing
                max = curr;
                lmax = l;
                rmax = i;
            }
            if (curr < 0) {//if cur goes to negative that means 0's contribution has been reduced and 1s increase
                //so lets increase the left point as well that is (start of the sub array )
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
