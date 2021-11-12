package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class SubsetGeneration {


    public static void main(String[] args) {
        //15, 20, 12, 19, 4
        ArrayList<Integer> A = new ArrayList<>();
        A.add(15);
        A.add(20);
        A.add(12);
        A.add(19);
        A.add(4);
        ArrayList<ArrayList<Integer>> subsetsFormed = subsets(A);
        System.out.println(subsetsFormed);

    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        generateSubsets(new ArrayList<>(), 0, A, arrayList);
        Collections.sort(arrayList, new Comparator<ArrayList<Integer>>() {

            @Override

            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {

                int min_length = o1.size();

                if (min_length > o2.size()) min_length = o2.size();

                for (int i = 0; i < min_length; i++) {

                    if (o1.get(i) < o2.get(i)) return -1;

                    else if (o1.get(i) > o2.get(i)) return 1;

                }

                if (min_length == o1.size()) return -1;

                else if (min_length == o2.size()) return 1;

                return 0;

            }

        });
        return arrayList;
    }

    private static void generateSubsets(ArrayList<Integer> subsets, int index, ArrayList<Integer> A, ArrayList<ArrayList<Integer>> arrayList) {


        if (index == A.size()) {
            arrayList.add(new ArrayList<>(subsets));
            return;
        }

        //not selecting an index
        generateSubsets(subsets, index + 1, A, arrayList);
        //selecting an index
        subsets.add(A.get(index));
        generateSubsets(subsets, index + 1, A, arrayList);
        //backtracking
        subsets.remove(subsets.size() - 1);
    }

}

/*

 Collections.sort(arrayList, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
 */