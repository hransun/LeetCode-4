class WordFilter {
    //create a map<prefix_suffix, latest index>
    //because it will query lots of times(call f function) better to keep all possibles in the map
    // longest prefix_suffix is: eg: test => test_test
    Map<String, Integer> map;
    //init
    //S:O(length * length * number of words)
    //T
    public WordFilter(String[] words) {
        map = new HashMap<>();
        buildMap(map, words);
    }
    //Query: O(1)
    public int f(String prefix, String suffix) {
        String key = prefix+"_"+suffix;
        return map.get(key);
    }
    private void buildMap(Map<String, Integer> map, String[] words){
        for(int k = 0; k < words.length; k++){
            String cur = words[k];
            for(int i = 0; i < cur.length(); i++){
                String prefix = cur.substring(0,i+1);//这里的时间复杂度和下面一个for loop的时间复杂度是+的关系
                for(int j = cur.length()-1; j >= 0; j--){
                    String suffix = cur.substring(cur.length()-1-j, cur.length());
                    map.put(prefix+"_"+suffix, k);
                }
            }
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
 //trie tree
 class WordFilter {
    //Trie tree, keep two arraylist to keep the index
    class Trie{
        Trie[] array;
        List<Integer> prefixIndex;
        List<Integer> suffixIndex;
        Trie(){
            array = new Trie[26];
            prefixIndex = new ArrayList<>();
            suffixIndex = new ArrayList<>();
        }
    }

    Trie trie;
    public WordFilter(String[] words) {
        trie = new Trie();
        for(int i = 0; i < words.length; i++){
            // 正word
            updateTrie(words[i], i, true);
            //返word
            updateTrie(new StringBuilder(words[i]).reverse().toString(),i,false);
        }
    }

    public int f(String prefix, String suffix) {
        List<Integer> prefixAns = search(prefix, true);
        //suffix also need to reveres
        List<Integer> suffixAns = search(new StringBuilder(suffix).reverse().toString(), false);
        if(prefixAns.size() == 0 || suffixAns.size() == 0){
            return -1;
        }
        // need to return the largest, so search from the end
        int i = prefixAns.size() -1;
        int j = suffixAns.size()-1;
        while(i >= 0 && j >= 0){
            //两个integer比较相等，必须要用equals，因为integer用等于的比较范围是-128 到 127
            if(Objects.equals(prefixAns.get(i),suffixAns.get(j))){
                return prefixAns.get(i);
            }else if(prefixAns.get(i) > suffixAns.get(j)){
                i--;
            }else{
                j--;
            }
        }
        return -1;
    }

    private void updateTrie(String word, int index, boolean prefix){
        Trie node = trie;
        for(char c: word.toCharArray()){
            if(node.array[c-'a'] == null){
                node.array[c-'a'] = new Trie();
            }
            node = node.array[c-'a'];
            if(prefix){
                node.prefixIndex.add(index);
            }else{
                node.suffixIndex.add(index);
            }
        }
    }
    private List<Integer> search(String sub, boolean prefix){
        Trie node = trie;
        for(char c: sub.toCharArray()){
             node = node.array[c-'a'];
            if(node == null){
                return new ArrayList<>();
            }
        }
        return prefix? node.prefixIndex : node.suffixIndex;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
