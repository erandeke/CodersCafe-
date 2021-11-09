package math;

/**
 * @author Kedar Erande
 * PS:Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.
 *
 * Note: Your solution should run in logarithmic time complexity.
 *
 *
 */
public class TrailingZerosFactorial {
    public static void main(String[] args) {

        System.out.println(trailingZeroes(28));
    }

    public static int trailingZeroes(int A) {
        int i = 1;
        int a = -1;
        int ans = 0;
        while (a != 0 && a != 1) {
            int div = (int) (A / Math.pow(5, i));
            ans = ans + div;
            a = div;
            i++;
        }
        return ans;
    }
}
