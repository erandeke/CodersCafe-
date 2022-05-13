package dynamicprogr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class LongestSubsequence {

    public static int lis(final List<Integer> A) {
        int dp[] = new int[A.size()];
        Arrays.fill(dp, 1);
        for (int i = A.size() - 1; i >= 0; i--) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) < A.get(j) && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }

            }
        }

        int res = 0;
        for (int i = 0; i < A.size(); i++)
            res = Math.max(res, dp[i]);
        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(9);
        arrayList.add(2);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(101);
        arrayList.add(18);

       /* arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        arrayList.add(3);*/
        System.out.println(lis(arrayList));
    }
}
