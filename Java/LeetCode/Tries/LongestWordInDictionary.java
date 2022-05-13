package Tries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kedar Erande
 *
 */
public class LongestWordInDictionary {
    public static void main(String[] args) {

        String words[] = {"w", "wo", "wor", "worl", "world"};
        String str = longestWord(words);
        System.out.println(str);

    }

    public static String longestWord(String[] words) {
        //sort the words so that smaller words come before
        Arrays.sort(words);
        Set<String> built = new HashSet<String>();
        String res = "";
        for (String w : words) {
            //start building the word
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                res = w.length() > res.length() ? w : res;//this check is to check if the word
                //is larger than res that means res can be formed and in lexico smaller way since sorted
                //if we dont apply this check and simply put res =w then it will get the different op
                //which is not lexico smaller for example : {"a","ap","app","apple","apply","banana"}
                //here it will overwrite the answer with apply if we dont measure the length
                built.add(w);
            }
        }
        return res;

    }
}
