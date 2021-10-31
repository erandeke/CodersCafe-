package array.medium;

/**
 * @author Kedar Erande
 * Pair SUm :
 * Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.
 *
 * Since the answer may be large, return the answer modulo (109 + 7).
 *  A = [1, 2, 3, 4, 5]
 *  B = 2
 * Op: 4
 * TC : O(n) + O(B/2)
 */
public class PairSum {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        int B = 2;
        System.out.println(getTheCountOfPairsDivisibleByB(arr, B));
    }

    private static int getTheCountOfPairsDivisibleByB(int arr[], int B) {
        long count[] = new long[B];//taking the count array that denotes the remainder of every number when taken mod with
        int mod = 1000000007;


        for (int i = 0; i < arr.length; i++) {
            count[arr[i] % B]++; // store the count of remainder
        }
        int i = 1, j = B - 1;
        long ans = ((count[0] * (count[0] - 1))/ 2)%mod;
        //wheh i nd j 0 that also forms the valid pair hence take the ans


     // this loop is gonna run B/2 times
        while (i <= j) {
            if (i == j) {
                //here cnt[i] * cnt[j] --> this is each cnt of i will form the pair with each count of j
                //divide by 2 is there will be A,B and B, A as well that forms he pair and we want only amongst them
                ans = (ans + (count[i] * (count[j] - 1)) / 2)%mod;


            } else {
                ans = (ans + count[i] * count[j])%mod;

            }
            i++;
            j--;
        }

        return (int) ans;

    }
}
