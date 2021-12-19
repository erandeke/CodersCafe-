package contest;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Kedar Erande
 */
public class MakeArrayEqual {
    public static void main(String[] args) {
        int A[] = {4, 1, 2, 5, 4};
        // System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int min = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            int b = A.get(i);
            while (min != b) {
                if (min > b) min >>= 1;
                else b >>= 1;
            }
        }
        int cnt = 0;
        for (int x : A) {
            if (x == min) continue;
            else {
                while (x != min) {
                    cnt++;
                    x >>= 1;
                }
            }
        }
        return cnt;
    }
}
