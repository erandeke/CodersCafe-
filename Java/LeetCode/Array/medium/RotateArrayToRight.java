package Array.medium;

/**
 * @author Kedar Erande
 */
public class RotateArrayToRight {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        int b[] = rotateArray(arr, 3);
        for (int i : b)
            System.out.println(i);
    }

    private static int[] rotateArray(int arr[], int K) {
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            int index = (i + K) % arr.length;
            ans[index] = arr[i];

        }

        return ans;
    }
}
