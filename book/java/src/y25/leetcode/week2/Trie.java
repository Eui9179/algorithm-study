package y25.leetcode.week2;

public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
    }

    private final Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.next[index] == null) {
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.next[index] == null)
                return false;
            current = current.next[index];
        }
        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.next[index] == null)
                return false;
            current = current.next[index];
        }
        return true;
    }

    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd = false;
    }
}