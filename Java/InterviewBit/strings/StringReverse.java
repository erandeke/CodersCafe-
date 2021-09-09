package strings;

/**
 * @author Kedar Erande
 *
 * PS: Given a string A of size N.
 *Return the string A after reversing the string word by word.
 *
 * Input 1:
 *     A = "the sky is blue"
 * OP:
 * "blue is sky the"
 *
 * Note : Trim the leading or trailing spaces
 * TC: O(n)
 * Sc: O(n)
 */
public class StringReverse {
    public static void main(String[] args) {
        // String A = "The sky is Blue";
        String A = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        String B = fetch(A);
        System.out.println(B);
    }

    private static String fetch(String A) {
        char arr[] = A.toCharArray();
        char result[] = new char[arr.length];
        int left = 0;
        int right = arr.length - 1;
        getReverse(arr, left, right);
        getReverseOfEachChar(arr);
        String backed = generateString(arr);
        return backed;
    }

    private static String generateString(char arr[]) {
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString().trim();
    }

    private static void getReverseOfEachChar(char arr[]) {
        int i = 0;
        int j = 0;
        while (i < arr.length - 1 && j < arr.length) {
            while (j < arr.length && arr[j] != ' ') {
                j++;
            }
            int temp = j;
            j--;
            getReverse(arr, i, j);
            i = temp + 1;
            j = temp + 1;
        }

    }

    private static void getReverse(char arr[], int left, int right) {

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
//[e, u, l, B,  , s, i,  , y, k, s,  , e, h, T]

//Approach II)

   /* private static String getReverse(String A) {
        StringBuilder sb = new StringBuilder();
        String Arr[] = A.split(" ");
        for (int i = Arr.length - 1; i >= 0; i--) {
            sb.append(Arr[i]).append(" ");
        }
        return sb.toString().trim();

    }*/