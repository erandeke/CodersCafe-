package CP.bits;

/**
 * @author Kedar Erande
 */
public class TwiceRepeating {
    public static void main(String[] args) {
        int arr[] = {1,2,3,1,2,4};
        int A[] = find(arr);
        for (int i : A) {
            System.out.println(i);
        }
    }

    private static int[] find(int arr[]) {
        int xor = 0;
        int ans[] = new int[2];
        //First take XOR of all numbers now only unique will be left out
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }

        //find the set bit any set bit in that xor that we found earlier
        //intution here is that bit will be eiher set in x or y since it cannot be set in both as xor will nullify it
        //now problem reduces to find numbers having that ith bit set and numbers havibg ith bit unset
        //then take the xor of set and unset numbers
        int any_set_bit = 0;
        for (int i = 0; i <= 31; i++) {
            int x = (1 << i);
            if ((xor & x) != 0) {
                any_set_bit = i;
                break;
            }
        }

        //divide in set and unset
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            int desc = (arr[i] & (1 << any_set_bit));
            if (desc != 0) {
                x = x ^ arr[i];
            } else {
                y = y ^ arr[i];
            }
        }
        ans[0] = x;
        ans[1] = y;
        return ans;
    }
}
