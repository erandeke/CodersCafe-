package array.medium;

/**
 * @author Kedar Erande
 */
public class ClosestMinMx {
    public static void main(String[] args) {

        int arr[] = {3, 5, 2, 5, 4, 1, 3};
        //int arr[] = {1, 3};
        System.out.println(getTheMinClosestDistance(arr));
    }

    private static int getTheMinClosestDistance(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int last_max = 0;
        int last_min = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                last_max = i;
            }
            if (arr[i] < min) {
                min = arr[i];
                last_min = i;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            //The idea here is to calculate the distance between last max and lastmin and should be minimum
            if (arr[i] == min) {
                res = Math.min(res, (Math.abs(last_max - i) + 1));
                last_min = i;
            }
            if (arr[i] == max) {
                res = Math.min(res, (Math.abs(last_min - i) + 1));
                last_max = i;
            }

        }
        return res;
    }
}
