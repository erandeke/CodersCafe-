package array.easy;

/**
 * @author Kedar Erande
 * <p>
 * PS: Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
 * Approach by the formula :
 * we need to consider two cases:
 * <p>
 * 1)A>B
 * As we know B=B
 * =A-(A-B)
 * Taking mod on both sides
 * B%(A-B) = (A-(A-B))%(A-B)
 * By distributive property
 * LHS will remaning same
 * B%(A-B) = A%(A-B)
 * therefore (A-B) = M
 * A-B = M  is the answer
 *  Similarly for B> A
 *  ans of M = abs (B-A)
 *
 */
public class FindMaxPositiveM {
    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}
