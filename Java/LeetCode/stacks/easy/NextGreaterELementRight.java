package stacks.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Kedar Erande
 */
public class NextGreaterELementRight {
    public static void main(String[] args) {

        int nums1[] = {4, 1, 3};
        int nums2[] = {1, 3, 4, 4};
        int arr[] = findGreatestNearerELement(nums1, nums2);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    private static int[] findGreatestNearerELement(int nums1[], int nums2[]) {

        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        //check of the size of the stack is empty then push -1 to the array that means no element wil
        /*
           will be greater than that of the last element
           2)if the top of the stack is greater than the next element of arr then push the top to the ans array
           3)if the top of the stack is lesser than the element then pop that element till u find the element
           at top from the stack is grater than current element from array or the size of the stack reduces to zero
            Now on popping if the size of the stack becomes zero then that means no element found gretaer than that
            hence push -1 to the ans array
            or if the top found greater than the current element then push the top to ans array

         */

        for (int i = nums2.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                hashMap.put(nums2[i], -1);
            } else if (st.peek() > nums2[i]) {
                hashMap.put(nums2[i], st.peek());
            } else if (st.peek() < nums2[i]) {
                while (st.size() > 0 && st.peek() <= nums2[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    hashMap.put(nums2[i], -1);
                } else {
                    hashMap.put(nums2[i], st.peek());
                }
            }
            st.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            int val = nums1[i];
            if (hashMap.containsKey(val)) {
                arr.add(hashMap.get(val));
            }
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

}
