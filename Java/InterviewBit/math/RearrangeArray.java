package math;

/**
 * @author Kedar Erande
 *
 * PS: The array should be re-arranged in such way that
 * 3,2,0,1
 * Op: 1,0,3,2
 * Note : no extra space
 *
 * Approach : if we consider any two numbers between 0 to n-1 then
 * b*n % n ---> is the same number
 * then by formula : a+bn % n --> will give the a and a+bn/n will give the b
 * so "a" should be incremented by such way that it will give the quotient as index
 * we do not want mod to return index as it may give 0 when directly divisible
 * Tc: O(n)
 *
 * Old value can be obtained by arr[i]%n and a new value can be obtained by arr[i]/n.
 */
public class RearrangeArray {
    public static void main(String[] args) {

        int arr[] = {3, 2, 0, 1};
        RearrangeArray rearrangeArray = new RearrangeArray();
        rearrangeArray.rearrange(arr, arr.length);
        rearrangeArray.printArr(arr, arr.length);
    }

    void rearrange(int arr[], int n) {
        // First step: Increase all values by (arr[arr[i]]%n)*n
        for (int i = 0; i < n; i++)
            arr[i] += (arr[arr[i]] % n) * n;

        // Second Step: Divide all values by n
        for (int i = 0; i < n; i++)
            arr[i] /= n;
    }

    void printArr(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }


}
