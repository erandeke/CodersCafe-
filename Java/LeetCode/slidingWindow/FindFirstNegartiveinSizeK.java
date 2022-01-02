package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kedar Erande
 */
public class FindFirstNegartiveinSizeK {
    public static void main(String[] args) {
        int nums[] = {12, -1, -2, 3, -1, 4, -1, 2, -1};
        ArrayList<Integer> arr = getTheNegativesInArrayFromWindow(nums);
        System.out.println(arr);

    }

    private static ArrayList<Integer> getTheNegativesInArrayFromWindow(int nums[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        int j = 0;
        int k = 3;

        /*
           i and j pointers - for sliding j will traverse till arr size
           while (j<size)
            //increment j till window size is not met -k
            //when j-i+1 == k that means we have got the hit as we reached the window size
            //then start calculating we have chances of getting answer
            while(j<n)
            {
              if(j-i+1==k)
              //compute
              //get the answer
              //remove ith element from the ans since we are going to slide in next step
              //slide the window i++,j++
              else
              {
              j++
              }
             }


         */


        while (j < nums.length) {
            if (nums[j] < 0) {
                q.add(nums[j]);
            }
            if (j - i + 1 == k) {
                if (q.size() == 0) {
                    result.add(0);
                } else {
                    result.add(q.peek());
                    if (nums[i] == q.peek()) {
                        q.poll();
                    }
                    i++;
                    j++;

                }
            } else {
                j++;
            }
        }

        return result;
    }
}
