package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kedar Erande
 *
 * P.S -> Check if the sum is Present for
 * Given an array A and a integer B. A pair(i,j) in the array is a good pair if i!=j and (A[i]+A[j]==B). Check if any good pair exist or not.
 *
 * TC: O(1)
 * Using Hashing
 * Sc: O(n)
 */
public class CheckSumifPresent {
    public static void main(String[] args) {

    }


    public int solve(ArrayList<Integer> A, int B) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {

            if (map.containsKey(B - A.get(i)))
                return 1;
            map.putIfAbsent(A.get(i), i);
        }
        return 0;
    }
}
