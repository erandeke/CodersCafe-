package array.medium;

/**
 * @author Kedar Erande
 * This algorithm should run in O(n)
 */
public class FindMissingPositiveInteger {
    public static void main(String[] args) {

        //int arr[] = {3, 4, -1, 1};
        //int arr[] = {-8, -7, -6};
        //int arr[] = {8, 10, 1, -3, 2, -5};
        //int arr[] = {1};
        //int arr[] = {1, 2, 3, 4, 5, 6};
        int arr[] = {-7};
        System.out.println(findTheMissingNumber(arr));

    }

    private static int findTheMissingNumber(int arr[]) {
        int min = 1;
        int max = arr.length;
        int i = 0;
        int ans = 0;
        while (i < max) {
            //This condition will help to indentify which elements are eligible for swap
            //the missing positive
            if ((arr[i] >= min && arr[i] <= max) && arr[i] != arr[arr[i] - 1] && arr[i] >= 1) {
                //swap the element ti get to its right position
                //till then donot incement the index
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            } else {
                i++;
            }
        }

        int j = 0;

        //This for loop is for matching the index with their elements
        // if unmatch found after the swap then it means the index (element missing)
        //we have found
        for (; j < arr.length; j++) {
            int k = j + 1;
            if (arr[j] != k) {
                ans = k;
                break;
            }
        }

        //if the array of size 0 to N -> N+1 is the missing first element
        if (ans == 0) {
            ans = j + 1;
            return ans;
        }

        return ans;
    }
}
