package Heap;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 * https://www.hackerearth.com/practice/notes/heaps-and-priority-queues/
 * Use array to conevrt into heap form of data structre
 */
class MaxHeapy {
    ArrayList<Integer> maxHeapFormList;

    public MaxHeapy() {
        maxHeapFormList = new ArrayList<>();
    }

    public void add(int element) {
        maxHeapFormList.add(element);
        upheapify(maxHeapFormList.size() - 1);
    }

    public void upheapify(int leafIndex) {
        int pi = (leafIndex - 1) / 2;
        if (maxHeapFormList.get(leafIndex) > maxHeapFormList.get(pi)) {
            swap(leafIndex, pi);
            upheapify(pi);
        }
    }

    public void swap(int i, int j) {
        int ith = maxHeapFormList.get(i);
        int jth = maxHeapFormList.get(j);
        maxHeapFormList.set(i, jth);
        maxHeapFormList.set(j, ith);
    }

    public void printPath() {
        for (int i : maxHeapFormList) {
            System.out.println(i);
        }
    }

    public void remove() {
        swap(0, maxHeapFormList.size() - 1);
        int val = maxHeapFormList.remove(maxHeapFormList.size() - 1);
        downHeapify(0);

    }

    public void downHeapify(int parentIndex) {
        int max = parentIndex;
        int leftIndex = 2 * parentIndex + 1;
        int rightIndex = 2 * parentIndex + 2;
        if (leftIndex < maxHeapFormList.size() && maxHeapFormList.get(leftIndex) > maxHeapFormList.get(max))
            max = leftIndex;
        if (rightIndex < maxHeapFormList.size() && maxHeapFormList.get(rightIndex) > maxHeapFormList.get(max))
            max = rightIndex;
        if (max != parentIndex) {
            swap(max, parentIndex);
            downHeapify(max);
        }
    }

    //Not require though we are only inetrested to have the the max heap build . This is jst for test
    public int peek() {
        return maxHeapFormList.get(0);
    }

}


public class MaxHeap {
    public static void main(String[] args) {
        MaxHeapy maxHeapy = new MaxHeapy();
        maxHeapy.add(10);
        maxHeapy.add(20);
        maxHeapy.add(30);
        maxHeapy.add(40);
        maxHeapy.add(50);
        System.out.println(maxHeapy.peek()); //50
        System.out.println();
        maxHeapy.printPath();//50 -> 40 -> 20 -> 10-> 30
        System.out.println();
        maxHeapy.remove();//This will remove peek element : 50
        System.out.println();
        System.out.println(maxHeapy.peek());//40
        System.out.println();
        maxHeapy.printPath(); //40 -> 30 -> 20 -> 10
        maxHeapy.remove();
        maxHeapy.printPath();


    }
}
