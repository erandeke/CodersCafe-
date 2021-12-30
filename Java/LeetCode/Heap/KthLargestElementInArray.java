package Heap;

import java.util.PriorityQueue;

/**
 * @author Kedar Erande
 */
public class KthLargestElementInArray {
    public static void main(String[] args) {
        int nums[] = {3, 2, 1, 5, 6, 4};
        int K = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums) {
            minHeap.add(i); //Throw all the elements in Heap
            if (minHeap.size() > K) { //Since its a mean heap we want to keep only K elements in the heap
                //and since its mean heap by default it will have the top element as answer
                minHeap.remove();
            }
        }
        int x = minHeap.remove();
        System.out.println(x);

    }
}
