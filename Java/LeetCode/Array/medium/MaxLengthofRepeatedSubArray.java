package Array.medium;

/**
 * @author Kedar Erande
 */
public class MaxLengthofRepeatedSubArray {
    public static int findLength(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] memo = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; --i) {
            for (int j = nums2.length - 1; j >= 0; --j) {
                if (nums1[i] == nums2[j]) {
                    memo[i][j] = memo[i + 1][j + 1] + 1; //we are caching the value of dp
                    //once we have it
                    /*
                    This will work as follows :
                    1)when 1 from num1 and num2 mateches we are keeping it in arr[4][2];
                    why i+1 since when the next match found we have take the dp value
                    which we  have cahched in the i+1 and j+1 place and just add 1 to it
                    then find max


                     */


                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3, 2, 1};
        int nums2[] = {3, 2, 1, 4, 7};
        System.out.println(findLength(nums1, nums2));


    }
}
