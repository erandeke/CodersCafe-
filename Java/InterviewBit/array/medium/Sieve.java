package array.medium;

/**
 * @author Kedar Erande
 * TC : O(n log(log n)
 */
public class Sieve {
    public static void main(String[] args) {

        getNumbersWhichArePrime(12);

    }

    private static void getNumbersWhichArePrime(int n) {

        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < prime.length; i++) {
            prime[i] = true;
        }

        //This below for loop will be the to check the number has got the factors with it
        //p=2 is what the lowest prime that we can have
        //p*p -> since we  dont want to check for the numbers which are greater than N
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                //This for loop is for making the multiples of that number as false since we got the factors
                for (int i = p * p; i <= n; i = i + p) {
                    prime[i] = false;
                }
            }
        }
        for (int i = 2; i <= 10; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
