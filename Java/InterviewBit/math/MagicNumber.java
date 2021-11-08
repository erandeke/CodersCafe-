package math;

/**
 * @author Kedar Erande
 * <p>
 * PS: Find N'th magic number :
 * Given an integer A, find and return the Ath magic number.
 * <p>
 * A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
 * <p>
 * First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 * <p>
 * Apprroach : given that we will have 5 as the first number therefore calculate the next number for A such that considering
 * binary for A=3 will be = 0 1 1 =>  1*5^1 + 1*5^2 => 30
 * therefore for A=3 ans will be 30
 * <p>
 * TC : logbase2A -> Since we are dividing the nuumber A
 */
public class MagicNumber {
    public static void main(String[] args) {

    }

    public int solve(int A) {
        int ans = 0;
        int x = 1;
        while (A > 0) {
            x = x * 5;
            if (A % 2 == 1) {
                ans = ans + x;
            }
            A = A / 2;
        }
        return ans;
    }
}
