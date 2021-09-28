package hashing;

import java.util.*;

/**
 * @author Kedar Erande
 */
public class KOcurrences {
    public static void main(String[] args) {

        List<Integer> trees = Arrays.asList(1, 2, 2, 3, 3);
        int K = 2;
        System.out.println(solve(trees, K));
    }

    private static int solve(List<Integer> c, int K) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < c.size(); i++) {
            if (hashMap.containsKey(c.get(i))) {
                int count = hashMap.get(c.get(i));
                hashMap.put(c.get(i), ++count);
            } else {
                hashMap.put(c.get(i), 1);
            }
        }

        for (Map.Entry<Integer, Integer> trees : hashMap.entrySet()) {
            if (K == trees.getValue()) {
                sum += trees.getKey();
            }
        }

        if (sum != 0)
            return sum;

        return -1;
    }
}
