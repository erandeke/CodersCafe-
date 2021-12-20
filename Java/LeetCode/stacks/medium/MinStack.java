package stacks.medium;

import java.util.Stack;

/**
 * @author Kedar Erande
 * https://leetcode.com/problems/min-stack/
 */
class Min {

    Stack<Integer> st;
    Stack<Integer> minStack;

    public Min() {
        st = new Stack();
        minStack = new Stack();

    }

    public void push(int val) {

        st.push(val);

        if (minStack.size() == 0 || minStack.peek() >= val) {
            minStack.push(val);
        }

    }

    public void pop() {
        int ans = 0;
        if (!st.isEmpty()) {
            ans = st.peek();
            st.pop();
        }
        if (minStack.peek() == ans) {
            minStack.pop();
        }

    }

    public int top() {
        if (st.size() == 0) {
            return -1;
        }
        return st.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) {
            return -1;
        }

        return minStack.peek();

    }

}

public class MinStack {
    public static void main(String[] args) {

    }

}
