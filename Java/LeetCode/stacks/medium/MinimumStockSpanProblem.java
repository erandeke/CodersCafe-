package stacks.medium;

import java.util.Map;
import java.util.Stack;

/**
 * @author Kedar Erande
 */

class Pair {
    private int num;
    private int index;

    Pair(int num, int index) {
        this.index = index;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


public class MinimumStockSpanProblem {
    public static void main(String[] args) {

        int ar[] = {100, 80, 60, 70, 60, 75, 85};
        int ans[] = generateMinimumStockSpanProblem(ar);
        for (int i : ans) {
            System.out.println(i);
        }


    }

    private static int[] generateMinimumStockSpanProblem(int arr[]) {
        Stack<Pair> st = new Stack<>();
        // int nglIndex[] = new int[arr.length];
        Pair ans[] = new Pair[arr.length];
        int counter[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek().getNum() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = new Pair(arr[i], 1);
            } else {
                int idx = st.peek().getIndex();
                ans[i] = new Pair(arr[i], i - idx);
            }
            st.push(new Pair(arr[i], i));
        }
        for (int i = 0; i < ans.length; i++) {
            counter[i] = ans[i].getIndex();
        }
        return counter;
    }
}
