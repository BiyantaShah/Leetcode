package fullTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Biyanta on 06/10/17.
 */
public class Trie {

    TrieNode root ;
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public Trie () {
        root = new TrieNode();
    }

    public static void main (String[] args ){

        Trie trie = new Trie();

        trie.insert("abcd");
        trie.insert("abgl");
        trie.insert("lmn");
        System.out.println(trie.search("abcd"));

        trie.delete(trie.root, "abcd", 0);
        System.out.println(trie.search("abcd"));
    }

    private boolean delete(TrieNode current, String word, int index) {

        if (index ==  word.length()) {

            if (!current.endOfWord)
                return false;

            current.endOfWord = false;

            return current.children.size() == 0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if (node == null)
            return false;

        boolean shouldDeleteCurrentNode = delete(node, word, index+1);

        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            return current.children.size() == 0;
        }

        return false;
    }

    private boolean search(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode node = current.children.get(ch);
            if (node == null)
                return false;

            current = node;
        }

        return current.endOfWord;
    }

    private void insert(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode node = current.children.get(ch);
            if (node  ==  null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }

        current.endOfWord = true;
    }
}
