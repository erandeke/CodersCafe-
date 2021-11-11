package CP.bits;

/**
 * @author Kedar Erande
 */
public class DifferentPairBitsSolutionFinal {
    public static void main(String[] args) {

        int arr[] = {1, 3, 5};
        System.out.println(cntBits(arr));
    }

    private static int cntBits(int arr[]) {
        long ans = 0;
        long count = 0;
        long mod = (long) 1e9 + 7;
        for (int i = 0; i <= 31; i++) {
            count=0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            ans += 2 * count * (arr.length - count);
            ans = ans % mod;
        }
        return (int)ans;
    }
}
