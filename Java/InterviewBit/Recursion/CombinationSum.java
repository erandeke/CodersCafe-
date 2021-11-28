package Recursion;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Kedar Erande
 */
public class CombinationSum {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> res = new CombinationSum().findCombinationSum();
        System.out.println(res);

    }

    private ArrayList<ArrayList<Integer>> findCombinationSum() {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int target = 4;
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(1);
        input.add(2);
        input.add(2);
        Collections.sort(input);
        generateCombinationSum(input, new ArrayList<>(), 0, target, res);
        return res;
    }

    private void generateCombinationSum(ArrayList<Integer> input, ArrayList<Integer> ds, int index,
                                        int target, ArrayList<ArrayList<Integer>> res) {

        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < input.size(); i++) {
            if (i > index && input.get(i) == input.get(i - 1))
                continue;
            if (input.get(i) > target)
                break;
            ds.add(input.get(i));
            generateCombinationSum(input, ds, i + 1, target - input.get(i), res);
            ds.remove(ds.size() - 1);

        }
    }
}
