package math;

/**
 * @author Kedar Erande
 */
public class ModSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2};
        System.out.println(getTheModSum(arr));
    }

    private static int getTheModSum(int arr[]) {
        int mod = (int) 10e9 + 7;
        int n = arr.length;
        int cnt[] = new int[1001];
        for (int a : arr) {
            cnt[a]++;
        }
        int sum = 0;
        for (int i = 1; i < cnt.length; i++) {
            for (int j = 1; j < cnt.length; j++) {
                int value = i % j;
                int temp = cnt[i] * cnt[j] * value;
                sum = ((sum % mod) + (temp % mod)) % mod;
            }
        }

        return sum;

    }
}
