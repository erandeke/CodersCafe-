package Array.easy;

/**
 * @author Kedar Erande
 */
public class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int start_pointer = 0;
        int mid_pointer = n;
        int end = 2 * n;
        int res[] = new int[end];

        int i = 0;
        while (start_pointer < mid_pointer && mid_pointer < end) {
            res[i++] = nums[start_pointer]; //x1
            res[i++] = nums[mid_pointer]; //y1
            start_pointer++;
            mid_pointer++;

        }

        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2, 5, 1, 3, 4, 7};
        shuffle(nums, 3);
    }
}
