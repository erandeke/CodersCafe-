package array.medium;

/**
 * @author Kedar Erande
 */
public class EuclideanAlgorithm {
    public static void main(String[] args) {
        System.out.println(gcd(36, 60));
    }

    private static int gcd(int A, int B) {
        if (A == 0)
            return B;
        return gcd(B % A, A);
    }
}
