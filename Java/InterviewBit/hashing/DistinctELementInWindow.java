package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kedar Erande
 *
 * PS: find the distinctelement count in the subarray of size K
 *
 * AP: Need to take hashmap to maintain the count frequency 2)increase the count only when the incoming element is == 1
 * that means the element is unique in the subarray and can con be considered as eligible candidate
 *
 * //Step 2: decrease the count of i-b element by 1 as its one poping out of subarray . At times if it occur that
 * i-B count becomes 0 then reduce the main count as '0' indicates that element is completely removed or doesnt
 * exists in the array
 * TC : O(n)
 */
public class DistinctELementInWindow {
    public static void main(String[] args) {

        //int A[] = {1, 2, 1, 3, 4, 3};
         int A[] = {1, 1, 2, 2};
       // int A[] = {31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31};
        //int A[] = {2, 7, 7, 81, 81};
        int B[] = solve(A, 1);
        for (int i : B) {
            System.out.println(i);
        }
    }

    private static int[] solve(int A[], int B) {

        int n = A.length;
        int countArray[] = new int[n - B + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int existingCount = 0;
        for (int i = 0; i < B; i++) {
            if (!hashMap.containsKey(A[i])) {
                hashMap.put(A[i], 1);
                count += 1;
            } else {
                existingCount = hashMap.get(A[i]);
                hashMap.put(A[i], ++existingCount);
            }
        }
        res.add(hashMap.size());

        for (int i = B; i < A.length; i++) {
            if (A[i] != A[i - B]) {
                if (!hashMap.containsKey(A[i])) {
                    hashMap.put(A[i], 1);
                } else {
                    existingCount = hashMap.get(A[i]);
                    hashMap.put(A[i], ++existingCount);
                }


                hashMap.put(A[i - B], hashMap.get(A[i - B]) - 1);
                if (hashMap.get(A[i]) == 1) {
                    count += 1;
                }
                if (hashMap.get(A[i - B]) == 0) {
                    count -= 1;
                }
            }

            res.add(count);
        }

        int arr[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
}
