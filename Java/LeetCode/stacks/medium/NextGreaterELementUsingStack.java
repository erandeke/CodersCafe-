package stacks.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kedar Erande
 */
public class NextGreaterELementUsingStack {
    public static void main(String[] args) {

        int nums[] = {1, 2, 3, 4, 3};
        int ans[] = nextGreaterElements(nums);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[nums.length];
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }

            if (i < nums.length) {
                if (stack.isEmpty() == false) nge[i] = stack.peek();
                else nge[i] = -1;
            }
            stack.push(nums[i % nums.length]);
        }

        return nge;
    }

}
