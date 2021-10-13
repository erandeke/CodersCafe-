package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class MergeTwoArrays {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4, 7, 9);//This creates list which is backed by an array which is fixed sized and cannot be modified
        //Hence we need to create a new ArrayList

        List<Integer> list1 = new ArrayList<>(Arrays.asList(4, 7, 9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2, 11, 19));


        List<Integer> listX = solve(list1, list2);
        System.out.println(listX);
    }

    public static ArrayList<Integer> solve(final  List<Integer> A, final List<Integer> B) {
        List<Integer> mergedList = new ArrayList<>(A);
        mergedList.addAll(B);
       Collections.sort(mergedList);
        return (ArrayList<Integer>) mergedList;


    }
}
