package Array.hard;

/**
 * @author Kedar Erande
 * https://leetcode.com/problems/trapping-rain-water/submissions/
 */
public class RainWaterTrapping {
    public static void main(String[] args) {

        //int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr[] = {3, 0, 0, 2, 0, 4};
        System.out.println(printRainWaterTrappedInBuildings(arr));
    }

    private static int printRainWaterTrappedInBuildings(int arr[]) {
        int maxLeft[] = new int[arr.length];
        int maxRight[] = new int[arr.length];
        int sum = 0;
        maxLeft[0] = arr[0];
        maxRight[maxRight.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }
        return sum;
    }
}
