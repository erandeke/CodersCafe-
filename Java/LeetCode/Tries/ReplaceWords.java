package Tries;

import java.util.Arrays;
import java.util.List;

/**
 * @author Kedar Erande
 */

class TrieNode {
    TrieNode node[];
    String word;

    public TrieNode() {
        node = new TrieNode[26];
    }
}

/*

Let N = the # of words in dictionary.
Let W = the average length of word in dictionary.
Let L = the length of the sentence.

Isn't the time complexity O(NW + L)?

We need NW time to set up the trie.
And then L time to find a root for each word in the sentence.
Overall, O(NW + L).
 */

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode tn = new TrieNode();
        //put all the roots on trie

        for (String root : dictionary) {
            TrieNode curr = tn;
            for (char c : root.toCharArray()) {
                if (curr.node[c - 'a'] == null) {
                    curr.node[c - 'a'] = new TrieNode();
                }
                curr = curr.node[c - 'a'];
            }
            curr.word = root;
        }

        StringBuilder sb = new StringBuilder();
        for (String wrd : sentence.split("\\s+")) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            TrieNode curr = tn;
            for (char letter : wrd.toCharArray()) {
                if (curr.node[letter - 'a'] == null || curr.word != null)//curr.word!=null
                    //is very important check for the given like inputs that checks for the node word is not null
                    //that means we have the succesor of that root
                    break;
                curr = curr.node[letter - 'a'];
            }
            sb.append(curr.word != null ? curr.word : wrd);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        //  List<String> ip = Arrays.asList("cat", "bat", "rat");
        //String sentence = "the cattle was rattled by the battery";
        List<String> ip = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String sent = replaceWords.replaceWords(ip, sentence);
        System.out.println(sent);


    }
}
