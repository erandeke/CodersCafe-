package array;

/**
 * @author Kedar Erande
 */
public class ConstructArray {
    public static void main(String[] args) {

        int ans[] = solve(5, 20, 50);
        for (int i : ans) {
            System.out.println(i);
        }
    }

    public static int[] solve(final int A, final int B, final int C) {
        int[] ans = new int[A];
        if (A == 2) {
            ans[0] = B;
            ans[1] = C;
            return ans;
        }

        for (int i = 0; i < A; i++) {
            ans[i] = Integer.MAX_VALUE;
        }
        for (int a = 1; a <= 50; a++) {// a - for the first term
            for (int d = 1; d <= 50; d++) {//d will be common difference that should be increase
                int[] tmp = new int[A];//temp array for storing the sequence

                for (int i = 0; i < A; i++) {
                    tmp[i] = a + i * d; //store the sequence generated outta a and d  i will be for generating the common difference
                }

                boolean fB = false; //notifier to check if the B and C are occurred in the sequence
                boolean fC = false;

                for (int i = 0; i < A; i++) {
                    if (tmp[i] == B)
                        fB = true;
                    else if (tmp[i] == C)
                        fC = true;

                }
                if (fB && fC && tmp[A - 1] < ans[A - 1]) { // Since we need to generate array which is having minimum posssible max value
                    //hence the comparison the above if block
                    for (int i = 0; i < A; i++) {
                        ans[i] = tmp[i];
                    }
                }
            }
        }

        return ans;
    }

}

