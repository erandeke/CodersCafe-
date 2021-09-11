package math;

/**
 * @author Kedar Erande
 */
public class Palindrome {
    public static void main(String[] args) {
        int val = isPalindrome(121);
        System.out.println(val);
    }

    public static int isPalindrome(int A) {
        int rev = 0;
        int remainder = 0;
        int original = A;

        //Negative numbers can never be palindrome
        if (A < 0)
            return 0;
        while (A != 0) {
            remainder = A % 10;
            rev = rev * 10 + remainder;
            A = A / 10;

        }
        if (rev == original) {
            return 1;
        }

        return 0;


    }
}
