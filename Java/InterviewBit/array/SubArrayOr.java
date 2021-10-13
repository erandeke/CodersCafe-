package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class SubArrayOr {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(solve(arr));
    }

    public static int solve(ArrayList<Integer> a1) {
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            ArrayList<Integer> bits = new ArrayList<>();
            for (int j = 0; j < a1.size(); j++) {
                bits.add((a1.get(j) >> i) & 1); //Get the set bits
            }
            ans += (Math.pow(2, i) * getSubArrayWithSumZeroOrOne(bits) % 1000000007);
            //This above logic multiples power of 2^0 wih sum of 1s excluding 0 from total subarrays
            //likewise for subsequent powers 2^1 with sum of 1s excluding 0 from total subarray so on and so forth
        }

        return (int) (ans % 1000000007);
    }


    private static long getSubArrayWithSumZeroOrOne(ArrayList<Integer> bits) {
        int i = 0;
        long total = 0;
        long cz = 0;

        long totalPossibleSubArrays = ((long) bits.size() * ((long) (bits.size() + 1))) / 2;
        //Calculate the total subarray --> (n* (n+1))/2;

        while (i < bits.size()) {
            if (bits.get(i) == 1) {
                total += (cz * (cz + 1)) / 2; // If 1 occurs in consecutive 0 then get the total subarray count of zero
                cz = 0;
            } else {
                cz++; //if zero then increase the count of zero

            }
            i++;
        }
        total += (cz * (cz + 1)) / 2; //this is reqired when the input is 1000 since there is no trailing 1

        return totalPossibleSubArrays - total;
    }
}
