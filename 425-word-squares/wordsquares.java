class Solution {
    public List<List<String>> wordSquares(String[] words) {
        //build trie tree with list of(prefix)
        //bfs
        // start with each word in the words
        //  w a l l
        //   a r e a
        // l e a d
        // l a d y
        // level 1 is the start word "wall"
        //   level 2 find the word start with "a"
        // level 3 find the word start with "ar"
        // level 4 find the word start with " lea"
        //T: O(n!) s: O(n)
        TrieNode root = buildTrie(words);
        List<List<String>> list = new ArrayList<>();
        for(String s: words){
            //start from each word
            List<String> cur = new ArrayList<>();
            cur.add(s);
            dfs(list,cur, root,1);
        }
        return list;
    }
    private void dfs(List<List<String>> list, List<String> cur, TrieNode root, int index){
        if(index == cur.get(0).length()){
            list.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder sb = new StringBuilder();
        //build prefix
        for(String s: cur){
            sb.append(s.charAt(index));
        }
        //找到所有包含prefix前缀的words
        List<String> found = search(root, sb.toString());
        for(String s: found){
            cur.add(s);
            dfs(list,cur, root, index+1);
            //这里一定要写remove list中的最后一个元素
            //不能直接写remove s， 因为会有duplicate element，可能就会remove 错误
            cur.remove(cur.size()-1);
        }
    }

    private List<String> search(TrieNode root, String prefix){
        for(char c: prefix.toCharArray()){
            root = root.children[c-'a'];
            if(root == null){
                //在任意一次没有找到，返回空list
                return new ArrayList<>();
            }
        }
        //root指向最后一个字母
        return root.startWith;
    }
    private class TrieNode {
        // a list of string which start with "String"
        // ie: all the words start with "ab"
        List<String> startWith = new ArrayList<>();
        TrieNode[] children = new TrieNode[26];
    }
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String s: words){
            TrieNode cur = root;
            for(char c: s.toCharArray()){
                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
                cur.startWith.add(s);
            }
        }
        return root;
    }
}
