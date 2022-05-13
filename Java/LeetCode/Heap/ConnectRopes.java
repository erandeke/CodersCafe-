package Heap;

import java.util.PriorityQueue;

/**
 * @author Kedar Erande
 */
public class ConnectRopes {

    private int mincost(int A[]) {
        int sum = 0;
        int cost = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while (priorityQueue.size() > 1) {
            int x = priorityQueue.poll();
            int y = priorityQueue.poll();
            sum = x + y;
            priorityQueue.add(sum);
            cost = cost + sum;

        }
        return cost;
    }

    public static void main(String[] args) {

    }
}
