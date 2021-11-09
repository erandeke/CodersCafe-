package CP.fastexpo;

/**
 * @author Kedar Erande
 */
public class BinaryExpo {
    public static void main(String[] args) {

        System.out.println(binaryExprRecur(2, 2));
    }

    private static int binaryExprRecur(int a, int b) {
        int mod = (int) 1e9 + 7;
        if (b == 0)
            return 1; // if b becomes 0 that means power o for any number will be 1
        int res = binaryExprRecur(a, b / 2);
        if (b % 2 != 0)
            return (int) (a * ((res * 1L * res) % mod)) % mod;
        else
            return (int) (res * 1L * res) % mod;
    }
}
