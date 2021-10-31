package array.medium;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

/**
 * @author Kedar Erande
 *
 * //This apprroach is right but to find out how we can take the last element from  the map
 */
public class MaxDistanceArray {
    public static void main(String[] args) {
        //int arr[] = {3, 5, 1, 4, 2};
        int arr[] = {3, 5, 4, 2};
        System.out.println(getMaxDistance(arr));
    }

    private static int getMaxDistance(int arr[]) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        int max_j_distance = 0;
        int ans = 0;
        int curr_ans = 0;


        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        indexMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByKey());

        int n = indexMap.size();
        max_j_distance = indexMap.get(n);
        ans = 0;
        for (int i = n - 1; i > 0; i--) {
            int curr_index = indexMap.get(i);
            curr_ans = max_j_distance - curr_index;
            ans = Math.max(ans, curr_ans);
            if (curr_index > max_j_distance) {
                max_j_distance = curr_index;
            }
        }

        return ans;
    }
}
