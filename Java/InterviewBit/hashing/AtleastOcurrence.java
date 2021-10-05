package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Kedar Erande
 */
public class AtleastOcurrence {
    public static void main(String[] args) {
        int A[] = {1, 1, 2};
        int B[] = {2, 3};
        int C[] = {3};

        int D[] = new AtleastOcurrence().solve(A, B, C);
        for (int i : D) {
            System.out.println(i);
        }
    }

    public int[] solve(int[] A, int[] B, int[] C) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i < A.length; i++) {
            hashMap.put(A[i], 1);
        }

        for (int i = 0; i < B.length; i++) {
            if (hashMap.containsKey(B[i])) {
                int count = hashMap.get(B[i]);
                hashMap.put(B[i], ++count);
            } else {
                hashMap.put(B[i], 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            if (hashMap.containsKey(C[i])) {
                int count = hashMap.get(C[i]);
                hashMap.put(C[i], ++count);
            } else {
                hashMap.put(C[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> freq : hashMap.entrySet()) {
            if (freq.getValue() >= 2) {
                ts.add(freq.getKey());
            }
        }
        int arr[] = ts.stream().mapToInt(Integer::intValue).toArray();

        Arrays.sort(arr);
        return arr;

    }

}
