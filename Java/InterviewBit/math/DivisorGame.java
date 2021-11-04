package math;

/**
 * @author Kedar Erande
 *
 * PS: Scooby has 3 three integers A, B and C.
 *
 * Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell number of special integers less than or equal to A.
 *
 * Approach : get the GCD of B and C , find the LCM since after LCM we will get all the numbers which are multiple of B and C
 * hence we can obtain the total count by dividing A/LCM
 * TC : (log(min(b,c)) -> to find gcd
 */
public class DivisorGame {
    public static void main(String[] args) {

    }
    public int solve(int A, int B, int C) {

        int gcd_value = gcd(B,C);
        int LCM = (B*C)/gcd_value;
        return A/LCM;
    }

    private static int gcd(int B , int C)
    {
        if(B==0)
            return C;

        return gcd(C%B, B);
    }
}
