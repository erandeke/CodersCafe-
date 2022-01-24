/**
 * @author Kedar Erande
 */


class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public TrieNode insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
        return node;
    }


    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (node.containsKey(ch))
                node = node.get(ch);
            else
                return null;
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

public class TrieOps {
    public static void main(String[] args) {
        Trie trieNode = new Trie();
        trieNode.insert("play");
        trieNode.insert("player");
        trieNode.insert("playing");
        trieNode.insert("PLAY");
        //  boolean exist = trieNode.search("player");
        boolean exist = trieNode.search("ked");
        System.out.println(exist + "Word exists");
        boolean startsWith = trieNode.startsWith("play");
        System.out.println(startsWith + "Starts With exists");


    }
}
