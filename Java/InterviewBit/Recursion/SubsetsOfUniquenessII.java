package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class SubsetsOfUniquenessII {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(
                Arrays.asList(1, 2, 2)
        );

        getTheSubsets(arrayList);
    }

    private static ArrayList<ArrayList<Integer>> getTheSubsets(ArrayList<Integer> inputList) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        backTrack(results, current, 0, inputList);
        return results;
    }

    private static void backTrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current, int index, ArrayList<Integer> inputList) {
        if (index == inputList.size()) {
            res.add(new ArrayList<>(current));
        }
       //didnt work by this way
        if (index > 0 && inputList.get(index) != inputList.get(index - 1)) {
            current.add(inputList.get(index));
            backTrack(res, current, index + 1, inputList);
            current.remove(current.size() - 1);
            backTrack(res, current, index + 1, inputList);

        }


    }
}
