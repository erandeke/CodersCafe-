package array.easy;

/**
 * @author Kedar Erande
 * PS:
 * You have an array A with N elements. We have 2 types of operation available on this array :
 * We can split a element B into 2 elements C and D such that B = C + D.
 * We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
 * You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?
 *
 */
public class InterestingArray {
    public static void main(String[] args) {
        int A[] = {24,24};
        System.out.println(solve(A));
    }
    public static String solve(int[] A) {
        int count=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%2!=0)
            {
                count++;
            }
        }
        if(count%2==0)
        {
            return "Yes";
        }

        return "No";
    }

}
