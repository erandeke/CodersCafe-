package array.easy;

/**
 * @author Kedar Erande
 *
 * PS: To find the largest integer whose GCD is co-prime
 * You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
 *
 * X divides A i.e. A % X = 0
 * X and B are co-prime i.e. gcd(X, B) = 1
 *
 * Approach :
 */
public class CoPrimeDivisors {
    public static void main(String[] args) {
        System.out.println(getMaxCoPrime(36, 60));
    }

    private static int getMaxCoPrime(int A, int B) {
        if (A == 1)
            return A;


        while (gcd(A, B) != 1) {
            A = A / gcd(A,B);
        }
        return A;
    }

    private static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
}
