package CP.fastexpo;

/**
 * @author Kedar Erande
 */
public class Factorial {
    public static void main(String[] args) {

        System.out.println(fact(6));
    }

    private static int fact(int n) {
        if (n==0)
            return 1;
        else
            return n * fact(n - 1);
    }
}
