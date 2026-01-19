package y25.leetcode.week2;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208 {

    Map<String, Boolean> trie = new HashMap<>();

    public void insert(String word) {
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            if (trie.containsKey(prefix)) {
                continue;
            }
            trie.put(word.substring(0, i), false);
        }
        trie.put(word, true);
    }

    public boolean search(String word) {
        if (trie.containsKey(word)) {
            return trie.get(word);
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        return trie.containsKey(prefix);
    }

}
