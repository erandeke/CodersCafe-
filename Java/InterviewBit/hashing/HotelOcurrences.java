package hashing;

import java.util.*;

/**
 * @author Kedar Erande
 * <p>
 * PS->You are given an array A, consisting of the street numbers of hotels your friend has visited. Every street has just one hotel. Your friend can visit a hotel multiple times too.
 * You are supposed to make another array, that stores the indices of the hotels your friend has visited. The array should ignore the multiple visits to each hotel, and should only consider the last visit made to that hotel.
 * The array elements should be in order of visiting the hotels.
 * <p>
 * Input : A = [1, 2, 3, 2, 5, 3, 2, 4]
 * Op: [1, 5, 3, 2, 4]
 * Tc: O(nlogn)
 * Sc: O(n)
 */
public class HotelOcurrences {
    public static void main(String[] args) {
        int A[] = {1, 2, 3, 2, 5, 3, 2, 4};
        int B[] = new HotelOcurrences().solve(A);


    }

    public int[] solve(int[] A) {

        //store map using its indices and update it whenevr it finds existing ones
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++)

            if (hashMap.containsKey(A[i])) {
                hashMap.put(A[i], i);
            } else {
                hashMap.put(A[i], i);
            }


        //As we need to traverse with the lastest ones hence sort the values in asc order
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        //use linked hashMap to maintain the insertion order
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) temp.put(aa.getKey(), aa.getValue());

        Set<Integer> set = temp.keySet();

        int B[] = set.stream().mapToInt(Integer::intValue).toArray();

        return B;
    }
}
