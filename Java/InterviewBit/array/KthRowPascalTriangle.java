package array;

import math.RearrangeArray;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 *
 * Problem : Find the Kth row in Pascal triangle  https://www.mathsisfun.com/pascals-triangle.html
 */
public class KthRowPascalTriangle {
    public static void main(String[] args) {

        int A = 3;
        System.out.println(getRow(A));
    }

    public static ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> arr = new ArrayList<>();
        int res = 1;
        arr.add(res);
        for (int i = 1; i <= A; i++) {
            res = (res * (A - i + 1)) / i;
            arr.add(res);
        }
        return arr;
    }
}
