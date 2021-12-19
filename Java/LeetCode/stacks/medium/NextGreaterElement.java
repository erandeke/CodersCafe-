package stacks.medium;

/**
 * @author Kedar Erande
 */
public class NextGreaterElement {
    public static void main(String[] args) {

        int arr[] = {1,2,1};
        int p[] = nextGreaterElements(arr);
        for(int i:p)
        {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}
