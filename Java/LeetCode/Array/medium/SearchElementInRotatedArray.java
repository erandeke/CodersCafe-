package Array.medium;

/**
 * @author Kedar Erande
 * <p>
 * <p>
 * //Search the elememnt in possbile rotated array
 */
public class SearchElementInRotatedArray {
    public static void main(String[] args) {
        // int nums[] = {4, 5, 6, 7, 0, 1, 2};
        // int nums[] = {1, 2, 3, 4, 5};
        int nums[] = {1, 3};
        //mid = 7
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < nums[end]) { // condition to check if the target falls in mid and end
                if (nums[mid] < target && target <= nums[end]) { // check the target if gretaer than mid and lesse than end
                    start = mid + 1; // then increase the start so we have the probability of target bein presenet
                } else {
                    end = mid - 1;//if the target does not falls in between hence the part from mid to end can be ignored
                    //and end can be mid -1
                }
            } else {
                if (nums[start] <= target && target < nums[mid]) { // check if target falls between start and mid
                    end = mid - 1;//if yes then reduce the end from mid
                } else {
                    start = mid + 1;//if doesnt falls in between start and mid then increase the start as start=mid+1;
                }
            }
        }
        return -1;
    }
}
