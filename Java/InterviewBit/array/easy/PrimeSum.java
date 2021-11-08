package array.easy;

/**
 * @author Kedar Erande
 */
public class PrimeSum {
    public static void main(String[] args) {

        int arr[] = primeSum(12);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] primeSum(int A) {

        boolean prime[] = new boolean[A + 1];
        for (int i = 0; i <= A; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= A; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= A; i = i + p) {
                    prime[i] = false;
                }
            }

        }


        int arr[] = new int[2];
        for (int i = 2; i <= A; i++) {
            int x = A - i;
            if (prime[i] && prime[x]) {
                arr[0] = i;
                arr[1] = x;
                break;
            }


        }

        return arr;
    }


}
