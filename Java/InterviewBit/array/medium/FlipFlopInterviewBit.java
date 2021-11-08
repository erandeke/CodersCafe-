package array.medium;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 */
public class FlipFlopInterviewBit {
    public static void main(String[] args) {

        String A = "1101010001";
        ArrayList<Integer> arrayList = flip(A);
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> flip(String A) {
        int prefix_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        int left_index = 0;
        int right_index = 0;
        int best_left_index = -1;
        int best_right_index = -1;
        ArrayList<Integer> arrayList = new ArrayList<>();
        int arr[] = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            int p = Integer.valueOf(String.valueOf(c));
            arr[i] = p == 0 ? 1 : -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                prefix_sum = prefix_sum + arr[i];
                if (prefix_sum > max_sum) {
                    max_sum = prefix_sum;
                    best_left_index = left_index;
                    best_right_index = right_index;
                    right_index++;
                }
            } else {
                left_index = i + 1;
                right_index = i + 1;
                prefix_sum = 0;
            }

        }
        if (best_left_index != -1 && best_right_index != -1) {
            arrayList.add(best_left_index + 1);
            arrayList.add(best_right_index + 1);
        }

        return arrayList;
    }
}
