package stacks.medium;

import java.util.Stack;

/**
 * @author Kedar Erande
 */

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public int next(int price) {
        //here we are maintianing the counter that would count the difference between the
        //current and next greater element to its left

        int counter = 1;//by default it will be 1 as the we want to find consecutive lesser than or equal to spans
        //if not found lesser than then atleas we would have the number in itself
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            counter = counter + stack.pop()[1];
        }
        stack.push(new int[]{price, counter});
         return counter;
    }

}

public class StockSpannerLeetcode {
    public static void main(String[] args) {

    }
}
