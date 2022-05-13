package Tries;

import java.util.HashMap;

/**
 * @author Kedar Erande
 */
class TrieLink {

    public HashMap<Character, TrieLink> wordDictionary;

    boolean isEnd;

    public TrieLink() {
        wordDictionary = new HashMap<>();
    }

    public void setEnd() {
        isEnd = true;
    }


}

class Trie {

    TrieLink root;

    public Trie() {
        root = new TrieLink();
    }

    public void addWordInDictionary(String word) {
        int length = word.length();
        TrieLink curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.wordDictionary.containsKey(word.charAt(i)))
                curr.wordDictionary.put(word.charAt(i), new TrieLink());
            curr = curr.wordDictionary.get(word.charAt(i));
        }
        curr.setEnd();
    }


    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }


    public boolean searchHelper(String word, int pos, TrieLink node) {
        if (pos == word.length())
            return node.isEnd;

        if (word.charAt(pos) == '.') {
            for (Character c : node.wordDictionary.keySet()) {
                if (searchHelper(word, pos + 1, node.wordDictionary.get(c)))
                    return true;
            }
        }

        if (!node.wordDictionary.containsKey(word.charAt(pos)))
            return false;

        return searchHelper(word, pos + 1, node.wordDictionary.get(word.charAt(pos)));

    }


}


public class AddAndSearchWords {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWordInDictionary("bad");
        trie.addWordInDictionary("dad");
        trie.addWordInDictionary("mad");
        boolean isAdPresent = trie.search("...");


        System.out.println(isAdPresent);
        // System.out.println(isAdPresent);
    }

}
