package CP.fastexpo;

/**
 * @author Kedar Erande
 *
 * Large Powers -> Binary exponention for calcuting fast powers + factorial using fermat theorem
 */
public class LargePowers {
    public static void main(String[] args) {

        System.out.println(solve(2, 27));
    }

    private static int solve(int A, int B) {
        long fact = fact(B);
        long res = binaryExprRecur(A, fact);
        return  (int)(res);
    }

    private static long fact(int n) {
        long mod = (long)1e9+7;
        if (n == 0)
            return 1;
        else
            return (long)(n * fact(n - 1))%(mod-1);//need to explore fermat theorem why mod-1
    }

    private static long binaryExprRecur(int a, long b) {
        long mod = (long)1e9+7;
        if (b == 0)
            return 1; // if b becomes 0 that means power o for any number will be 1
        long res = binaryExprRecur(a, b / 2);
        if (b % 2 != 0)
            return (a * ((res * res) % mod)) % mod;
        else
            return (res * 1L * res) % mod;
    }
}
