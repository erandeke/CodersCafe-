package array;

/**
 * @author Kedar Erande
 * PS : Find Arithmetic Progression. The number is in AP when the diff is equal between the consecutive nos
 * Approach : Calculate the diff first then traverse over the array and check if ot does not inline with the diff calculated
 * TC= o(n)
 * SC= O(1);
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int ret = findAp(arr);
        System.out.println(ret);
    }

    public  static int findAp(int arr[])
    {
        int diff = arr[1]-arr[0];
        for(int i=2;i< arr.length;i++)
        {
            if(arr[i]-arr[i-1]!=diff)
                return 0;
        }

        return 1;

    }

}
