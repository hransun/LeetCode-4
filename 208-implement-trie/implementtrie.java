class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
         boolean isWord = false;

    }
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
     root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(search(word)) {
            return;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children[word.charAt(i) - 'a'];
            if(next == null) {
                next = new TrieNode();
                cur.children[word.charAt(i) - 'a'] = next;
            }
            cur = next;
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children[word.charAt(i) - 'a'];
            if(next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
            TrieNode next = cur.children[prefix.charAt(i) - 'a'];
            if(next == null) {
                return false;
            }
            cur = next;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
