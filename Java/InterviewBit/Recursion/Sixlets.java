package Recursion;

/**
 * @author Kedar Erande
 */
public class Sixlets {
    public static void main(String[] args) {
        int arr[] = {400, 500, 300, 800, 100, 900};
        System.out.println(solve(arr, 3));
    }

    private static int solve(int A[], int B) {
        int ans = 0;
        int idx=0;
        int sum = 0;
        B = 3;
        ans = find(idx, sum, B, A);
        return ans;
    }

    private static int find(int idx, int sum, int size, int A[]) {
        int counter=0;
        if (sum > 1000)
            return 0;

        if (idx == A.length)
            return 0;
        if (size == 0) {
            counter++;
            System.out.println(counter);
            return 1;
        }

        return find(idx + 1, sum + A[idx], size - 1, A) + find(idx + 1, sum, size, A);
    }
}
