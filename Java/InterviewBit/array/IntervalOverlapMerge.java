package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 *
 * Todo - using stack and check the edge case as below "e"
 */

class IntervalMerge {
    private int start;
    private int end;

    public IntervalMerge(int start, int end) {
        this.start = start;
        this.end = end;
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

public class IntervalOverlapMerge {
    public static void main(String[] args) {
        IntervalMerge a = new IntervalMerge(1, 3);
        IntervalMerge b = new IntervalMerge(5, 7);
        IntervalMerge c = new IntervalMerge(2, 4);
        IntervalMerge d = new IntervalMerge(6, 8);
       // IntervalMerge e = new IntervalMerge(11, 12);

        List<IntervalMerge> mergedList = getMergedOverlappedList(Arrays.asList(a, b, c, d));
        for (int i = 0; i < mergedList.size(); i++) {
            IntervalMerge im = mergedList.get(i);
            System.out.println("Start-->" + im.getStart() + "  " + "End --->" + im.getEnd());

        }


    }

    private static List<IntervalMerge> getMergedOverlappedList(List<IntervalMerge> passedArray) {
        //sort the start time
        Collections.sort(passedArray, new Comparator<IntervalMerge>() {
            @Override
            public int compare(IntervalMerge o1, IntervalMerge o2) {
                return o1.getStart() - o2.getStart();
            }
        });


        //1)Take new list which will be mergedList
        //2)check if the curr interval is overlapping with the present interval
        //3)If the end time of curr is greater than exist then extend and remove

        List<IntervalMerge> mergedList = new ArrayList<>();
        mergedList.add(passedArray.get(0));

        for (int i = 1; i < passedArray.size(); i++) {
            int currSize = mergedList.size();
            IntervalMerge prev = mergedList.get(--currSize);
            IntervalMerge curr = passedArray.get(i);

            if (!(prev.getEnd() < curr.getStart() || curr.getEnd() < prev.getStart())) {
                if (curr.getEnd() > prev.getEnd()) {
                    IntervalMerge im = prev;
                    im.setEnd(curr.getEnd());
                    mergedList.add(im);
                    mergedList.remove(prev);
                }
            } else {
                mergedList.add(curr);
            }
        }

        return mergedList;
    }


}
