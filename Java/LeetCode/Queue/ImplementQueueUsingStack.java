package Queue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Kedar Erande
 */
class StackHelper {
    Stack<Integer> ip;
    Stack<Integer> op;
    LinkedList<Integer> lx;

    public StackHelper() {
        ip = new Stack<>();
        op = new Stack<>();
    }

    public void push(int x) {
        ip.push(x);
    }

    public int pop() {
        if (!op.isEmpty()) {
            int x = op.peek();
            op.pop();
            return x;
        }
        while (!ip.isEmpty()) {
            op.push(ip.pop());
        }
        return op.peek();
    }

    public int top() {
        if (!op.isEmpty())
            return op.peek();
        else {
            while (!ip.isEmpty()) {
                op.push(ip.pop());
            }
            return op.peek();
        }
    }

}

public class ImplementQueueUsingStack {
    public static void main(String[] args) {
        StackHelper st = new StackHelper();
        st.push(3);
        st.push(1);
        st.push(4);
        int x = st.top();
        System.out.println("Top element of Queue :->" + x);
        int y = st.pop();
        System.out.println("popped element of Queue :->" + y);
        int z = st.top();
        System.out.println("top element of Queue :->" + z);


    }
}
