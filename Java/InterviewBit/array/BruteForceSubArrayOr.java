package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class BruteForceSubArrayOr {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(getSumOfSubArrayOr(arrayList));
    }

    private static int getSumOfSubArrayOr(ArrayList<Integer> arr) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            temp = 0;

            for (int j = i; j < arr.size(); j++) {
                temp = temp | arr.get(j);
                sum += temp;
            }
        }
        return sum;
    }
}
