package Queue;

import java.util.*;

/**
 * @author Kedar Erande
 */

class QueueImpl {

    Queue<Integer> queue;

    QueueImpl() {
        this.queue = new LinkedList<>();

    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.peek());
            queue.poll();
        }

    }

    public int top() {
        if (!queue.isEmpty())
            return queue.peek();
        return -1;
    }

    public int pop() {
        if (!queue.isEmpty()) {
            int element = queue.poll();
            return element;
        }
        return -1;
    }


}


public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        QueueImpl que = new QueueImpl();
        que.push(3);
        que.push(2);
        que.push(4);
        que.push(1);
        int topElement = que.top();
        System.out.println(topElement);
        int poppedELement = que.pop();
        System.out.println(poppedELement);
        int nextToppedElement = que.top();
        System.out.println(nextToppedElement);


    }


}
