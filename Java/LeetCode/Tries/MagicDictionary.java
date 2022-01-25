package Tries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kedar Erande
 */

class Magic {
    HashMap<Integer, Set<String>> dict;
    Set<String> cache;

    public Magic() {
        dict = new HashMap<>();
        cache = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            int length = dictionary[i].length();
            if (!dict.containsKey(length))
                dict.put(length, new HashSet<>());
            dict.get(length).add(dictionary[i]);
        }
    }

    public boolean search(String word) {
        if (cache.contains(word))
            return true;
        if (!dict.containsKey(word.length()))
            return false;
        Set<String> st = dict.get(word.length());
        for (String s : st) {
            int counter = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != s.charAt(i))
                    counter++;
                if (counter > 1)
                    break;


            }
            if (counter == 1) {
                cache.add(word);
                return true;
            }

        }

        return false;
    }

}

public class MagicDictionary {
    public static void main(String[] args) {
        Magic magic = new Magic();
        /*String arr[] = {"hello", "leetcode", "hallo", "judge"};
        magic.buildDict(arr);
        boolean val1 = magic.search("hello");
        boolean val2 = magic.search("hallo");
        boolean val3 = magic.search("hell");
        boolean val4 = magic.search("leetcodd");
        boolean val5 = magic.search("judge");
        System.out.println(val1);
        System.out.println(val2);
        System.out.println(val3);
        System.out.println(val4);
        System.out.println(val5);*/
        String arr[] = {"hello", "leetcode"};
        magic.buildDict(arr);
        boolean val1 = magic.search("hatlo");
        System.out.println(val1);

    }
}
