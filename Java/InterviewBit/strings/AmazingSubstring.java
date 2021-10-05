package strings;

/**
 * @author Kedar Erande
 * You are given a string S, and you have to find all the amazing substrings of S.
 * <p>
 * Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
 * //ABEC
 * //total substring s= n(n+1)/2
 * //A -> A.length() - i + count
 * //E -> A.length() - index of E + count
 * /*
 * <p>
 * Explanation
 * Amazing substrings of given string are :
 * 1. A
 * 2. AB
 * 3. ABE
 * 4. ABEC
 * 5. E
 * 6. EC
 * here number of substrings are 6 and 6 % 10003 = 6.
 */
public class AmazingSubstring {
    public static void main(String[] args) {
        solve("ABEC");
    }

    public static int solve(String A) {
        int count = 0;
        for (int i = 0; i <= A.length() - 1; i++) {
            if (A.charAt(i) == 'a' || A.charAt(i) == 'e' || A.charAt(i) == 'i' ||
                    A.charAt(i) == 'o' || A.charAt(i) == 'u' || A.charAt(i) == 'A' || A.charAt(i) == 'E' ||
                    A.charAt(i) == 'I' || A.charAt(i) == 'O' || A.charAt(i) == 'U') {
                count += (A.length() - i);
            }
        }
        return count % 10003;
    }
}
