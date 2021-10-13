package Array.medium;

/**
 * @author Kedar Erande
 * <p>
 * PS: Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * TC : O(logn)
 */
public class FindTheFirstAdLastPositionInSortedA {
    public static void main(String[] args) {

        int arr[] = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int b[] = searchRange(arr, target);
        for (int i : b) {
            System.out.println(i);
        }

    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {   // mid find the start index or left index
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        int ans[] = new int[]{left, left};
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // this will higher upper mid
            if (target < nums[mid]) { // if the mid is greater than target then obvio right should be shifted
                right = mid - 1;
            } else { //else keep left mid as is
                left = mid;
            }
        }
        ans[1] = left;
        return ans;
    }
}
