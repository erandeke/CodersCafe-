package CP.bits;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 * PS: Given an array of integers, every element appears thrice except for one which occurs once.
 *
 * Find that element which does not appear thrice.
 *
 * NOTE: Your algorithm should have a linear runtime complexity.
 *
 * Could you implement it without using extra memory?
 *
 * TC : O(n) SC : O(32)
 */
public class ThriceRepeatBits {
    public static void main(String[] args) {
        int arr[] = {4, 4, 4, 2};
        System.out.println(generateBinary(arr));
    }

    private static int generateBinary(int arr[]) {
        ArrayList<Integer> bits = new ArrayList<>();
        for (int i = 0; i <= 31; i++) {
            int bitSum = 0;
            for (int j = 0; j < arr.length; j++) {
                bitSum += ((arr[j] >> i) & 1);
            }
            bits.add(bitSum);
        }

        int ans = 0;
        for (int i = 0; i < bits.size(); i++) {
            ans = ans + (1 << i) * (bits.get(i) % 3);
        }
        return ans;
    }
}
