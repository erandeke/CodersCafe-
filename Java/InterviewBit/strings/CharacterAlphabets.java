package strings;

/**
 * @author Kedar Erande
 * <p>
 * PS : check if all the characters are alphabets
 */
public class CharacterAlphabets {

    public static void main(String[] args) {

       // char A[] = {'S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'};
        char A[] = {'s','c','a','l'};
        int val = CharacterAlphabets.solve(A);
        System.out.println(val);
    }

    public static int solve(char[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 65 || A[i] > 122) {
                return 0;
            }

        }
        return 1;
    }
}
