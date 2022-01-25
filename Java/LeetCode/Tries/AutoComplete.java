package Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Kedar Erande
 */

class TrieDS {
    HashMap<Character, TrieDS> map;

    boolean isEnd;

    public TrieDS() {
        map = new HashMap<>();

    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

class TrieAutoComplete {
    TrieDS root;

    public TrieAutoComplete() {
        root = new TrieDS();
    }

    public void insert(String word) {
        TrieDS curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!curr.map.containsKey(ch))
                curr.map.put(ch, new TrieDS());
            curr = curr.map.get(ch);
        }
        curr.setEnd();
    }

    public List<String> performAutoComplete(String prefix) {
        TrieDS curr = root;
        List<String> res = new ArrayList<>();
        //Traverse till the prefix if we dont get prefix even then return empty list
        //since there is no point in travesing its child nodes
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.map.containsKey(prefix.charAt(i)))
                return res;
            curr = curr.map.get(prefix.charAt(i));
        }
        search(curr, res, prefix);
        return res;
    }

    public void search(TrieDS curr, List<String> res, String word) {
        if (curr == null)
            return;

        if (curr.isEnd)
            res.add(word);

        //get all the children from that prefix's found node and just append to the word
        /*

         for example
         prefix t-> e
         t->e->a-> m
         t->e-> a
         t->e->a ->c->h->e-> r
         */
        for (Character c : curr.map.keySet())
            search(curr.map.get(c), res, word + c);
    }


}


public class AutoComplete {
    public static void main(String[] args) {
        TrieAutoComplete tac = new TrieAutoComplete();
        tac.insert("team");
        tac.insert("tea");
        tac.insert("teacher");
        tac.insert("talk");
        List<String> autoCompleteResult = tac.performAutoComplete("te");
        System.out.println(autoCompleteResult);

    }
}
