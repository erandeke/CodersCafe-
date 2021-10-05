package array;

/**
 * @author Kedar Erande
 * <p>
 * N light bulbs are connected by a wire.
 * <p>
 * Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of current bulb.
 * <p>
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * <p>
 * You can press the same switch multiple times.
 * <p>
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * <p>
 * TC: O(n)
 */
public class bulbs {
    public static void main(String[] args) {
        int A[] = {0, 1, 0, 1};
        bulbs(A);
    }

    public static int bulbs(int[] A) {
        int ans = 0;

        for (int i = 0; i < A.length; i++) {
            if (ans % 2 != 0) {
                A[i] = A[i] == 0 ? 1 : 0;
            }
            if (A[i] == 0) {
                ans++;
            }
        }
        return ans;
    }
}
