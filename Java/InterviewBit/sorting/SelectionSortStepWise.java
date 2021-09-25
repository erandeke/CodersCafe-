package sorting;

/**
 * @author Kedar Erande
 *
 * PS: Return the minimum index after each iteration
 */
public class SelectionSortStepWise {
    public static void main(String[] args) {

        int A[] = {6, 4, 3, 7, 2, 8};
        int ans[] = solve(A);
        for (int i : ans) {
            System.out.println(i);
        }

    }

    public static int[] solve(int[] A) {
        int min_idex = 0;
        int B[] = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            min_idex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[min_idex]) {
                    min_idex = j;
                }
            }
            int temp = A[min_idex];
            A[min_idex] = A[i];
            A[i] = temp;
            B[i] = min_idex;
        }
        return B;

    }
}
