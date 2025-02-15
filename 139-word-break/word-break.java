import java.util.*;

class Solution {
    class Node {
        Node[] children;
        boolean eow;

        Node() {
            children = new Node[26];
            eow = false;
        }
    }

    Node root = new Node();
    Map<String, Boolean> memo = new HashMap<>(); // Memoization Map

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            if (i == word.length() - 1) {
                curr.eow = true;
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.eow;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        for (String st : wordDict) {
            insert(st);
        }
        return canBreak(s);
    }

    public boolean canBreak(String word) {
        if (word.length() == 0) {
            return true;
        }
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        for (int i = 1; i <= word.length(); i++) {
            if (search(word.substring(0, i)) && canBreak(word.substring(i))) {
                memo.put(word, true);
                return true;
            }
        }
        memo.put(word, false);
        return false;
    }
}
