package Recursion;

import java.util.*;

/**
 * @author Kedar Erande
 * //https://www.youtube.com/watch?v=qhBVWf0YafA
 */
public class Permutations {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        getThePermutations(arrayList);
    }

    private static ArrayList<ArrayList<Integer>> getThePermutations(ArrayList<Integer> A) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int num : A) {
            if (!frequencyMap.containsKey(num))
                frequencyMap.put(num, 0);
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        backtrack(comb, A.size(), frequencyMap, results);
        return results;

    }

    protected static void backtrack(
            LinkedList<Integer> comb,
            Integer N,
            HashMap<Integer, Integer> counter,
            ArrayList<ArrayList<Integer>> results) {

        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            // add this number into the current combination
            comb.addLast(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter, results);

            // revert the choice for the next exploration
            comb.removeLast();
            counter.put(num, count);
        }

    }
}
