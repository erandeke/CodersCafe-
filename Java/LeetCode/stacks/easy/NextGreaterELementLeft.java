package stacks.easy;

import java.util.Stack;

/**
 * @author Kedar Erande
 */
public class NextGreaterELementLeft {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 4};
        int ans[] = generateNextGretaterELementToLeft(arr);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    private static int[] generateNextGretaterELementToLeft(int arr[]) {
        int ans[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.size() == 0) {
                ans[i] = -1;
            } else if (st.size() > 0 && st.peek() > arr[i]) {
                ans[i] = st.peek();
            } else if (st.size() > 0 && st.peek() <= arr[i]) { //equal to sign for handling dups 1,3,4,4
                while (st.size() > 0 && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
