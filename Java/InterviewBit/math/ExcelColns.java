package math;

/**
 * @author Kedar Erande
 * <p>
 * Problem statement : Given a column title as appears in an Excel sheet, return its corresponding column number.
 * Approach :
 * A- 1
 * B-2
 * so and so forth for z-- 26
 * Take the base as 26
 * therefore A--> 1* 26^0 --> 1
 * B--> 2* 26^0 --> 2
 * now to calculate AB-->   A*26^1+B*26^0--> 26+2 --> 28
 *
 * Now how to calculate 1, 2, ... , 26 simply get the character at ith position and subtract using ascii . lets say AB
 * then A--> 1 ?  s.charAt(i)-'A'+ 1= 1
 * B-->2 ? s.charAt(i)-'A'+1 = 1+1 = 2
 *
 * TC = length of string--O(n)
 */
public class ExcelColns {
    public static void main(String[] args) {

        int val = titleToNumber("ABCD");
        System.out.println(val);
    }

    public static int titleToNumber(String A) {

        int n = A.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            result = result * 26 + (A.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
