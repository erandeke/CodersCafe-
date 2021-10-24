package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * @author Kedar Erande
 *
 * Observation: If we want to store the "h" unit of water  above the wall of height "x"  then there should be wall of
 * "x+h" height on left and to its right
 * Iterate each wall and find the left max height  and right max height wall to it
 */
public class RainWaterTrapping {
    public static void main(String[] args) {
        //ArrayList<Integer> arraysList = new ArrayList<>(Arrays.asList(1, 0, 2, 5, 1, 0, 3, 0, 0, 7));
        ArrayList<Integer> arraysList = new ArrayList<>(Arrays.asList(1, 2));
        System.out.println(trap(arraysList));
    }

    public static int trap(final List<Integer> A) {
        int lmax = 0;
        int rmax = 0;
        int res = 0;
        List<Integer> leftlist = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        //left iterate to find the lmax height
        for (int i = 0; i < A.size(); i++) {
            int leftRes = lmax - A.get(i);
            leftlist.add(leftRes);
            if (A.get(i) > lmax) {
                lmax = A.get(i);
            }
        }

       //right max
        for (int i = A.size() - 1; i >= 0; i--) {
            int rightRes = rmax - A.get(i);
            rightList.add(rightRes);
            if (A.get(i) > rmax) {
                rmax = A.get(i);
            }
        }

        int i = 0;
        int j = rightList.size() - 1;
        //need to compute with 0 since there can be negative difference
        //here we need to find min of left and right
        while (i < leftlist.size() && j >= 0) {
            int value = Math.min(leftlist.get(i), rightList.get(j));
            int min = value < 0 ? 0 : value;
            res = res + min;
            i++;
            j--;


        }

        return res;
    }

}

