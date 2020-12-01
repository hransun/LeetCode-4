class Solution {
    public int longestSubstring(String s, int k) {
        //T: O(n^2) brute force
        int length = 0;
        for(int i = 0; i< s.length(); i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
                if(valid(map,k)){
                    length = Math.max(length, j-i+1);
                }
            }
        }
        return length;
    }
    private boolean valid(Map<Character, Integer> map, int k){
        for(Map.Entry entry: map.entrySet()){
            if((int)(entry.getValue()) < k){
                return false;
            }
        }
        return true;
    }
}
