package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
public class FindFirstNegartiveinSizeK {
    public static void main(String[] args) {
        int nums[] = {12, -1, -2, 3, -1, 4, -1, 2, -1};
        ArrayList<Integer> arr = getTheNegativesInArrayFromWindow(nums);
        System.out.println(arr);

    }

    private static ArrayList<Integer> getTheNegativesInArrayFromWindow(int nums[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        int k = 3;

        while (j < nums.length) {
            if (nums[j] < 0) {
                q.add(nums[j]);
            }
            if (j - i + 1 == k) {
                if (q.size() == 0) {
                    result.add(0);
                } else {
                    result.add(q.peek());
                    if (nums[i] == q.peek()) {
                        q.poll();
                    }
                    i++;
                    j++;

                }
            } else {
                j++;
            }
        }

        return result;
    }
}
