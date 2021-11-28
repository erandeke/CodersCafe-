package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 *
 * The  target is given we need to find the ans here approach used is fix the i and j that is a and b
 * convert the problem in two sum
 * lets say a+b+c+d= target
 * Now we fix the a and b with for loop i and j target-a-j => target 2
 * Now we just need to loop from left to right adding value if that matches with the target2
 *
 * II)Also we need to skip duplicates
 * TC: O(n3 + nlogn) sc - o(1)
 */
public class FourSumProblem {
    public static void main(String[] args) {
        int arr[] = {4, 3, 3, 4, 4, 2, 2, 1, 1};
        Arrays.sort(arr);
        List<List<Integer>> res = new FourSumProblem().solve4sumProblem(arr);
        System.out.println(res);

    }

    private List<List<Integer>> solve4sumProblem(int arr[]) {
        List<List<Integer>> res = new ArrayList<>();
        int target = 9;
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int target2 = target - arr[i] - arr[j];
                 left = j + 1;
                while (left < right) {
                    if (arr[left] + arr[right] < target2) {
                        left++;

                    } else if (arr[left] + arr[right] > target2) {
                        right--;
                    } else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);
                        res.add(quad);

                        //process duplicates for left
                        while (left < right && arr[left] == arr[left + 1]) {
                            left++;
                        }
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;

                    }
                }

                //process duplicates for j -> second element
                while (j + 1 < arr.length && arr[j] == arr[j + 1]) {
                    j++;
                }
            }

            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                i++;
            }
        }

        return res;
    }
}
