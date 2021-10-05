package strings;

import java.util.ArrayList;

/**
 * @author Kedar Erande
 * <p>
 * Find the longest common prefix
 * Approach here is find the string which is smaller in length bceuase common prefix wont be longer than the
 * smallest string's length
 * <p>
 * Once we got the smallest string length traverse till its length and verify whether the char of it matches with the char
 * of the other strings  .If not mathable then break.
 * This means we are just checking the qulified string  for longest common prefix
 * TC here is (l*n)
 * where is l is the length of the smallest string and n is the length of the largest string
 * SC is O(n) --> can be made to O(1) just use String ans + ch where ch is the character that is common ;
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder pre = new StringBuilder();
        int smallestStringLen = Integer.MAX_VALUE;
        int indexOfSmallestString = 0;
        if (A.size() == 1)
            return A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (smallestStringLen > A.get(i).length()) {
                smallestStringLen = A.get(i).length();
                indexOfSmallestString = i;
            }
        }

        for (int i = 0; i <= smallestStringLen - 1; i++) {
            boolean isQualified = true;
            for (int j = 0; j <= A.size() - 1; j++) {
                if (A.get(indexOfSmallestString).charAt(i) != A.get(j).charAt(i)) {
                    isQualified = false;
                    break;
                }
            }
            if (isQualified) {
                pre.append(A.get(indexOfSmallestString).charAt(i));
            } else
                return pre.toString();

        }
        return pre.toString();
    }
}