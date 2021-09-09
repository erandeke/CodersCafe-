package array;

/**
 * @author Kedar Erande
 *
 * Problem Statement : To find the Kth Smallest element
 * Tc = K*n
 * Sc= o(1)
 * Approach : Iterate till Kth element for i and for j find the minimum and swap with the i for each jth iteration
 */
public class KthSmallest {

    public static void main(String[] args) {
        //call and get the index
        int A[] = {2,1,4,3,2};
        int val = new KthSmallest().kthsmallest(A,3);

    }

    public int kthsmallest(final int[] A, int B) {
        for(int i=0;i<B;i++)
        {
            int min_index=i;
            for(int j=i+1;j<A.length;j++)
            {
                if(A[j]<A[min_index])
                {
                    min_index=j;
                }
            }

            int temp=A[min_index];
            A[min_index]=A[i];
            A[i]=temp;
        }



        return A[B-1];
    }
}
