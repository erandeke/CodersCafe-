package array.medium;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Kedar Erande
 */
public class FactorialArray {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //2, 3, 4, 5, 6
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        System.out.println( solve(arrayList));
    }

    public static int solve(ArrayList<Integer> A) {

        final int mod = (int) 10e9 + 7;
        int max = A.get(0);
        for (int a : A) {
            max = Math.max(a, max);
        }
        int mpf[] = isPrimeBySolve(max);
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int a : A) {
            hm.put(mpf[a], hm.getOrDefault(mpf[a], 0) + 1);
        }
        long ans = 0;
        for (Integer i : hm.keySet()) {
            int n = hm.get(i);
            if (i == 0) continue;
            if (n == 1) ans = ans + 1;
            else ans = (ans % mod + (int) ((Math.pow(2L, n) % mod) - 1))%mod;
        }
        return (int) ans % mod;
    }

    private static int[] isPrimeBySolve(int max) {
        int ans[] = new int[max + 1];
        ans[0] = 0;
        ans[1] = 0;
        for (int i = 2; i <= max; i++) {
            if (ans[i] == 0) {
                ans[i] = i;
                for (int j = i * i; j <= max; j = j + i) {
                    ans[j] = -1;
                }
            }
        }

        int prev = ans[0];
        for (int i = 1; i < max + 1; i++) {
            if (ans[i] == -1) {
                ans[i] = prev;
            }
            prev = ans[i];
        }
        return ans;
    }
}
