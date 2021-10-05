package strings;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

/**
 * @author Kedar Erande
 */
public class LexoLargest {
    public static void main(String[] args) {

        String ans = getLargest("ittmcsvmoa_jktvvblefw");
        //String ans = getLargest("abb_c");
        System.out.println(ans);
    }

    public static String getLargest(String A) {

        String[] ST = A.split("_");
        String org = ST[0];
        String replacementString = ST[1];
        int[] freq_T = new int[26];
        StringBuilder sb = new StringBuilder(ST[0]);

        for (int i = 0; i < replacementString.length(); i++) {
            freq_T[(replacementString.charAt(i) - 'a')]++;
        }


        for (int i = 0; i < org.length(); i++) {
            char current_char = org.charAt(i);
            for (int k = 25; k >= 0; k--) {
                if ((k + 'a') > current_char && freq_T[k] > 0) {
                    current_char = (char) (k + 'a');
                    freq_T[k] -= 1;
                    break;
                }
            }
            sb.setCharAt(i, current_char);
        }
        return sb.toString();

    }
}
