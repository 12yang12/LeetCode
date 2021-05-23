package trie;

import java.util.HashMap;

public class LeetCode720 {

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Trie root = new Trie();
        for (String word : words) {
            Trie cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                } else {
                    Trie newNode = new Trie();
                    cur.children.put(c, newNode);
                    cur = newNode;
                }
            }
            cur.isEnd = true;
            cur.val = word;
        }

        String result = "";
        for (String word : words) {
            Trie cur = root;
            if (word.length() > result.length()
                    || (word.length() == result.length() && word.compareTo(result) < 0)) {
                boolean isWord = true;
                for (char c : word.toCharArray()) {
                    cur = cur.children.get(c);
                    if (!cur.isEnd) {
                        isWord = false;
                        break;
                    }
                }
                result = isWord ? word : result;
            }
        }
        return result;
    }
}

class Trie {
    public HashMap<Character, Trie> children = new HashMap<>();
    public String val = null;
    public boolean isEnd = false;
}