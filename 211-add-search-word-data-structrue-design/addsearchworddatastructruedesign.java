class WordDictionary {
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    //T: O(n) S: O(trieTree size ==> the unique character of dictionary)
    public void addWord(String word) {
        if(word == null || word.length() == 0 || search(word)) {
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


    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    //T: O(n) S: O(trieTree size ==> the unique character of dictionary)
    public boolean search(String word) {
        TrieNode cur = root;
       return helper(word, root, 0);
    }
    private boolean helper(String word, TrieNode cur,int index ){
        if(word== null || word.length() == 0) {
            return false;
        }
        if(index == word.length()) {
            return cur.isWord;
        }
            char temp = word.charAt(index);
            if(temp == '.') {
                for(int j = 0; j < 26; j++) {
                    TrieNode next = cur.children[j];
                    if(next != null) {
                       if(helper(word,next,index+1)){
                           return true;
                       }
                    }
                }
            }else {
                 TrieNode next = cur.children[temp - 'a'];
                 if(next == null) {
                     return false;
                 }
                if(helper(word,next,index+1)){
                           return true;
                 }

            }
        return false;
    }
}
