package Recursion;

import java.util.*;

/**
 * @author Kedar Erande
 */
public class SubsetsOfUniqueness {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(2);
        getTheSubsets(arrayList);

    }

    private static ArrayList<ArrayList<Integer>> getTheSubsets(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> storeTree = new ArrayList<>();
        backrack(storeTree, results, arrayList.size(), 0, arrayList);
        return results;
    }


    private static void backrack(ArrayList<Integer> store, ArrayList<ArrayList<Integer>> results, int n, int index, ArrayList<Integer> arrayList) {
        results.add(new ArrayList<>(store));
        for (int i = index; i < n; i++) {
            if ( i> index && arrayList.get(i) == arrayList.get(i - 1))
                continue;
            store.add(arrayList.get(i));
            backrack(store, results, n, i + 1, arrayList);
            store.remove(store.size() - 1);


        }
    }

}
