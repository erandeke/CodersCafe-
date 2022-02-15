package recursion.easy;

/**
 * @author Kedar Erande
 *
 * with O(1) space in iterative way
 */
public class ReverseIterativeWay {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }


    }

    public static void main(String[] args) {

    }
}
