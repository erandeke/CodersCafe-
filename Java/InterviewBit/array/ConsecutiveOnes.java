package array;

/**
 * @author Kedar Erande
 */


/*Length of longest consecutive ones InterviewBit
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive
1’s that can be achieved.

Expected TC: O(n)

Approach : Take all count of 1 - just to check at last if max in not equal to all count of 1
2.Calculate max from contiguous array(sub array) till encounters 0
3.Maintain Left and Right Array for count of consecutive 1 and 0
4.Check the consecutive  ones to the left of 0 and right - find its sum.
if sum is greater than max then update max

 */
public class ConsecutiveOnes {
    public static void main(String[] args) {

        //String A = "111011101";
       // String A = "1110000";
        String A= "01";
        System.out.println(new ConsecutiveOnes().solve(A));

    }

    public int solve(String A) {
        int max = 0;
        int temp = 0;
        int cnt_one = 0;

        //Check the max contiguous till you encounter 0

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1') {
                cnt_one++;
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }
        max = Math.max(max, temp);

        //fill the left Array and right Array

        int left[] = new int[A.length()];
        int right[] = new int[A.length()];

        //initialize the left and right 1st and last position with values from string
        //that will be used while filling the consecutive counts of 1

        if (A.charAt(0) == '1') {
            left[0] = 1;
        } else {
            left[0] = 0;
        }

        if (A.charAt(A.length() - 1) == '1') {
            right[A.length() - 1] = 1;
        } else {
            right[A.length() - 1] = 0;
        }

        //fill the consecutive count 1 array

        for (int i = 1; i < A.length() - 1; i++) {
            if (A.charAt(i) == '1') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        //right count array
        for (int i = A.length() - 2; i >= 0; i--) {
            if (A.charAt(i) == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }

        //Now check max

        for (int i = 1; i < A.length() - 1; i++) {
            if (A.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];
                //this condition is just to check if we not reach where max = all count
                if (sum < cnt_one) {
                    max = Math.max(max, sum + 1);
                } else {
                    max = Math.max(max, sum);
                }

            }
        }
        return max;
    }

}