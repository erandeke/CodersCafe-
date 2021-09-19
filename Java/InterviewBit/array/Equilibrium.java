package array;

/**
 * @author Kedar Erande
 *
 * Find the equilibrium index : Such that sum of the elements on the left is equal to the sum of the elements on right
 * Approach : Calc the right sum of all elements where left sum = 0
 * Traverse from i=0 to n then remove one from right and add one from left
 * sum of all elements (re) then reduce one by one and add to the left
 */
public class Equilibrium {
    public static void main(String[] args) {
        int A[] = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(A));
    }

    private static int solve(int A[]) {

        int min = Integer.MAX_VALUE;
        int ls = 0;
        int rs = 0;

        for (int i = 0; i < A.length; i++) {
            rs = rs + A[i];
        }

        for (int i = 0; i < A.length; i++) {
            rs = rs - A[i];
            if (ls == rs) {
                if (i < min) {
                    min = i;
                }
            }
            ls = ls + A[i];
        }
        if (min !=Integer.MAX_VALUE) {
            return min;
        }

        return -1;
    }
}
