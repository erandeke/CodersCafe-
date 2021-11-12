package array.easy;

/**
 * @author Kedar Erande
 */
public class DivideIntegers {
    public static void main(String[] args) {
        System.out.println(getDivsorWithoutUsingOperator(-2147483648, -1));
       // System.out.println(getDivsorWithoutUsingOperator(17,3));
       // System.out.println(getDivsorWithoutUsingOperator(-2147483648, 1));
        //range : MIN -2147483648   MAX: 2147483647
        int x = Integer.MIN_VALUE;
        int y =Integer.MAX_VALUE;
    }

    private static int getDivsorWithoutUsingOperator(int A, int B) {
     //need to convert mandatory in long since it will overflow
        long p = A;
        long q = B;
        int sign = 1;
        if (A > 0 && B < 0) {
            sign = -1;
        }
        if (A < 0 && B > 0) {
            sign = -1;
        }

        if (A < 0) {
            p = p * (-1);
        }
        if (B < 0) {
            q = q * (-1);
        }

        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (p - (q << i) >= 0) {
                p = p - (q << i);
                ans = ans + (long) Math.pow(2, i);

            }
        }
        //This condition is damn fantastic
        //The overflow will  occur only for the input which is greater than max
        //A = Integer.Max B=1  both bein postive will cause overflow on dividing
        //sign check here is since both are ppostive the sign will be 1 ie positive
        //if input would have been A= - 2147483648 and B = 1 that means ans will be A= - 2147483648
        //hence the ans will be 2147483648 as we take abs but adding sign to answer will be still withing the INT.MAX limit
        if (ans > Integer.MAX_VALUE && sign == 1)
            return Integer.MAX_VALUE;
        if (sign == -1) {
            ans = ans * -1;
        }
        return (int) ans;
    }

    private static void print(int A, int B) {
        System.out.println(A * B);
    }
}