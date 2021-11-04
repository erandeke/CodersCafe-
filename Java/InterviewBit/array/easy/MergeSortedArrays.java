package array.easy;

/**
 * @author Kedar Erande
 * <p>
 * TC : O(n1+n2)
 * SC : O(n1+n2);
 * <p>
 * Approach run i loop and j loop check if i is smaller than j if yes the add ith element and
 * increase the ith pointer till it finds j lesser
 * If i is greater than j then ->
 * otherwise add jth element
 * and increase the jth pointer till we find jthe element   less than i
 *
 * Dry run on {1,3,5,7} {4,6,8}
 */
public class MergeSortedArrays {
    public static void main(String[] args) {

        int arrA[] = {1, 3, 5, 7};
        int arrB[] = {2, 4, 6, 8};
        int arrC[] = mergeSortedArrays(arrA, arrB);
        for (int i : arrC) {
            System.out.println(i);
        }

    }

    private static int[] mergeSortedArrays(int arrA[], int arrB[]) {
        int n1 = arrA.length;
        int n2 = arrB.length;
        int arrC[] = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while ((i < n1 && j < n2)) {
            if (arrA[i] < arrB[j]) {
                arrC[k++] = arrA[i++];
            } else {
                arrC[k++] = arrB[j++];
            }
        }
        //copying of remaining elements
        while (i < n1) {
            arrC[k++] = arrA[i++];
        }

        while (j < n2) {
            arrC[k++] = arrB[j++];
        }
        return arrC;

    }
}
