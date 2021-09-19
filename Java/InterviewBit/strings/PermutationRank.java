package strings;

/**
 * @author Kedar Erande
 * Tc: n^2
 *
 * PS: This is to find the permuation rank of the string arranged in the lexo order
 * example "acb"
 * Permutation of lexo order will be  "abc" "acb" hence op 2:
 * AP : find the permuatation of each character which is supposed to be in lexo order in how many ways that can be arranged
 * return ans + 1 as the ans ==> number of strings arranged in lexo order before the actual ans
 */
public class PermutationRank {
    public static void main(String[] args) {
        System.out.println(solve("BDAC"));
    }

    private static int solve(String s) {
        int n = s.length();
        int ans = 0;
        char arr[] = s.toCharArray();
        int c = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            c = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (arr[j] < arr[i]) {
                    c++;
                }
            }
            ans = ans + (c * fact(n - i - 1)) % 1000003;

        }

        return (ans + 1) % 1000003;

    }

    private static int fact(int n) {
        if (n == 0) return 1;
        else return (n * fact(n - 1)) % 1000003;
    }
}
