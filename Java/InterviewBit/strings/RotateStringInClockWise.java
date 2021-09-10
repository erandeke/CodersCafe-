package strings;

/**
 * @author Kedar Erande
 */
public class RotateStringInClockWise {

    public static void main(String[] args) {

        String A = "scaler";
        int B = 2;
        System.out.println(new RotateStringInClockWise().solve(A,2));
    }

    public String solve(String A, int B) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char arr[] = new char[A.length()];
        char org[] = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            index = (i + B) % A.length();
            arr[index] = org[i];
        }

        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
