package stacks.hard;

import java.util.Stack;

/**
 * @author Kedar Erande
 */
public class MaxAreaHistogram {
    public static void main(String[] args) {

        // int heights[] = {2, 1, 5, 6, 2, 3};
        int heights[] = {1, 1};
        int x = largestRectangleArea(heights);
        System.out.println(x);
    }

    public static int largestRectangleArea(int[] heights) {
        int nsl[] = new int[heights.length];
        int nsr[] = new int[heights.length];
        int width[] = new int[heights.length];
        int max = Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 0 && heights[i] <= stack.peek()[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek()[1];
            }
            stack.push(new int[]{heights[i], i});
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && heights[i] <= stack.peek()[0]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nsr[i] = heights.length;
            } else {
                nsr[i] = stack.peek()[1];
            }
            stack.push(new int[]{heights[i], i});
        }

        for (int i = 0; i < heights.length; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
        }

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, width[i] * heights[i]);

        }
        return max;
    }
}
