package array; /**
 * @author Kedar Erande
 */


/*
InterviewBit
Problem Statement : Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p.

Example:  A = [3, 2, 1, 3]

Op: 1

Expected Time Complexity : O(n)

Approach : Sort (either in asc or desc, skip duplicates , handle case for first element 0 when sorted in
desc order and last element 0 when sorted in ascending order

 */


import java.util.ArrayList;
import java.util.Collections;

public class NobleInteger {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(new NobleInteger().solve(arr));
    }

    public int solve(ArrayList<Integer> A) {

        Collections.sort(A, Collections.reverseOrder());

        if(A.get(0)==0)
            return 1;

        for(int i=1;i<A.size();i++)
        {
            //input : 20,10,8,6,5,5
            //the A.get(i)!=A.get(i-1)--> to skip duplicates example : 4,4,4,4,4,1 --No noble integer
            if(A.get(i)==i && A.get(i) != A.get(i-1))
                return 1;
        }



        return -1;
    }
}

/*

Approach : When array is sorted in ascending order:

  public  int nobleInteger(int arr[])
    {
        Arrays.sort(arr);

        // Return a Noble element if present
        // before last.
        int n = arr.length;
        for (int i=0; i<n-1; i++)
        {
            if (arr[i] == arr[i+1])
                continue;

            // In case of duplicates, we
            // reach last occurrence here.
            if (arr[i] == n-i-1)
                return 1;
        }

        if (arr[n-1] == 0)
            return 1;

        return -1;
    }



 */