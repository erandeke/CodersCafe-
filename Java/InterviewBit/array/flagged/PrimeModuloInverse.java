package array.flagged;

/**
 * @author Kedar Erande
 * Need to understand binary exponention
 * Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
 *
 * A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
 * A=3 B=5
 */
public class PrimeModuloInverse {
    public static void main(String[] args) {

    }

    public int solve(int A, int B) {
        int result = 1;
        long p = B-2;
        long a = A;
        while(p>0)
        {
            if(p%2==1)
            {
                result = (int) ((result*a)%B);

            }
            a=(a*a)%B;
            p=p/2;
        }

        return result;

    }
}

