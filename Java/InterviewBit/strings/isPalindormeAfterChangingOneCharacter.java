package strings;

/**
 * @author Kedar Erande
 *
 * Find the palidrome if its possible to change only one character and return YES if its
 * handle the special cases for odd palidrome and even palindrome
 * TC is O(n) and Sc is O(1)
 */
public class isPalindormeAfterChangingOneCharacter {
    public static void main(String[] args) {

        System.out.println(isPalindrome("abcde"));
    }

    private static String isPalindrome(String A) {
        System.out.println(A.length());
        int left = 0;
        int right = A.length() - 1;
        int count = 0;

        while (left <= right) {
            if (A.charAt(left) != A.charAt(right)) {
                count += 1;
            }
            left++;
            right--;
            if (count > 1) {
                return "NO";
            }
        }

        if (count == 1) {
            return "YES";
        }

        if (A.length() % 2 != 0 && count == 0) {
            return "YES";
        }
        if (A.length() % 2 == 0 && count == 0) {
            return "NO";
        }

        return "NO";
    }
}
