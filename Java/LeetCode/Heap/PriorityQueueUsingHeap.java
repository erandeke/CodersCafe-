package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Kedar Erande
 */
class PriorityQ {
    ArrayList<Integer> data;

    public PriorityQ() {
        data = new ArrayList<>();
    }

    public void add(int element) {
        data.add(element);
        upheapfiy(data.size() - 1);


    }

    private void upheapfiy(int index) {
        if (index == 0)
            return;
        int parentIndex = (index - 1) / 2;
        if (data.get(index) < data.get(parentIndex)) {
            swap(index, parentIndex);
            upheapfiy(parentIndex);
        }
    }

    private void swap(int i, int j) {
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i, jth);
        data.set(j, ith);

    }

    public int remove() {
        if (data.size() == 0) {
            return -1;
        }
        swap(0, data.size() - 1);
        int val = data.remove(data.size() - 1);
        downheapify(0);
        return val;
    }

    private void downheapify(int i) {

        int min = i;
        int li = 2 * i + 1;
        int ri = 2 * i + 2;

        if (li < data.size() && data.get(li) < data.get(min)) {
            min = li;
        }
        if (ri < data.size() && data.get(ri) < data.get(min)) {
            min = ri;
        }
        if (min != i) {
            swap(min, i);
            downheapify(min);
        }


    }


    public int peek() {
        if (data.size() > 0) {
            return data.get(0);
        } else {
            System.out.println("Underflow");
        }
        return -1;
    }

    public int size() {
        return data.size();
    }

    public void printPath() {
        for (int i : data) {
            System.out.println(i);
        }
    }

}


public class PriorityQueueUsingHeap {
    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ();
        priorityQ.add(10);
        //priorityQ.add(10);
        priorityQ.add(20);
        priorityQ.add(30);
        priorityQ.add(40);
        priorityQ.add(50);
        priorityQ.add(5);

        int top = priorityQ.peek();
        System.out.println("Top element on queue of highest priority is :" + top);

        int element = priorityQ.remove();
        System.out.println("Removed elemeent :" + element);

        //Print now the path:
        priorityQ.printPath();



 /*
  priorityQ.data.add(10);
        priorityQ.data.add(20);
        priorityQ.data.add(30);
        priorityQ.data.add(40);
        priorityQ.data.add(50);
        priorityQ.data.add(5);
  */

    }
}
