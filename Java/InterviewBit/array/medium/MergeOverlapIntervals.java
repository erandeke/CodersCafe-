package array.medium;

import java.util.*;

/**
 * @author Kedar Erande
 * PS: Given a collection of intervals, merge all overlapping intervals.
 * [1,3],[2,6],[8,10],[15,18]
 * OP : [1,6],[8,10],[15,18]
 * Approach nlogn - sort the intervals and check for overlapping if the end is greater than start then
 * that is overlapping now its start will remain as is but the end we need to find the max end update the stack
 * if not overlapping then simply push onto the stack
 */

class Intervals {
    int start;
    int end;

    Intervals() {
        start = 0;
        end = 0;
    }

    Intervals(int s, int e) {
        start = s;
        end = e;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class MergeOverlapIntervals {
    public static void main(String[] args) {
        //[1,3],[2,6],[8,10],[15,18]
        ArrayList<Intervals> arr = new ArrayList<>();
       /* arr.add(new Intervals(1, 3));
        arr.add(new Intervals(2, 6));
        arr.add(new Intervals(8, 10));
        arr.add(new Intervals(15, 18));*/
        arr.add(new Intervals(2, 100));
        arr.add(new Intervals(100, 100));
        ArrayList<Intervals> res = mergeOverlapIntervals(arr);
        for (Intervals i : res) {
            System.out.println(i.getStart() + "" + i.getEnd());
        }


    }

    public static ArrayList<Intervals> mergeOverlapIntervals(ArrayList<Intervals> arr) {

        Stack<Intervals> stack = new Stack<>();
        ArrayList<Intervals> result = new ArrayList<>();
        Collections.sort(arr, new Comparator<Intervals>() {
            @Override
            public int compare(Intervals o1, Intervals o2) {
                return o1.start - o2.start;
            }
        });

        stack.push(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            Intervals top = stack.peek(); // get the first element from the stack
            int start1 = top.start; // start
            int end1 = top.end;//end

            int start2 = arr.get(i).start; //element to be inserted its start
            int end2 = arr.get(i).end; // and its end

            //Now the approach is if the end of first is greater than start of second
            //that means the interval is mergable example [1,6] [2,8] can become as [1,8]
            if (end1 >= start2) {
                stack.pop();
                end1 = Math.max(end1, end2);
                stack.push(new Intervals(start1, end1));
            } else {
                stack.push(new Intervals(start2, end2)); //otherwise push the element in stack
            }


        }

        for (int i = 0; i < stack.size(); i++) {
            result.add(stack.get(i));
        }
        return result;
    }
}
