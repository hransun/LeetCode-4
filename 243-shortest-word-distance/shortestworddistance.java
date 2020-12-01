class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        //T: O(n+i*j) S: O(Math.max(i,j))
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(s.equals(word1)){
                l1.add(i);
            }
            if(s.equals(word2)){
               l2.add(i);
            }
        }
        int res = words.length;
        for(int i: l1){
            for(int j: l2){
                res = Math.min(Math.abs(i-j), res);
            }
        }
        return res;
    }
}
