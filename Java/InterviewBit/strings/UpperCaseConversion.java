package strings;

/**
 * @author Kedar Erande
 * <p>
 * AP: ASCII table lower starts from : 97 and ends at 122
 * Upper starts from 65 and ends at 90
 */
public class UpperCaseConversion {
    public static void main(String[] args) {
        char A[] = {'s', 'c', 'a', 'l', 'e', 'r', '#'};
        System.out.println(to_upper(A));
    }

    private static char[] to_upper(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 97 && A[i] <= 122) {
                char c = A[i];
                A[i] = (char) (A[i] - 32);
            }
        }

        return A;
    }
}
