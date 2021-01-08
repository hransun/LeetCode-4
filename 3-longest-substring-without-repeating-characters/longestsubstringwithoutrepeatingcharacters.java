class Solution {
    public int lengthOfLongestSubstring(String s) {
        //fast.slow pointer
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c) && map.get(c) >= i){
                res = Math.max(res, j-i);
                i = map.get(c)+1;
            }
            map.put(c,j);
            j++;
        }
        res = Math.max(res, j-i);
        return res;
    }
}
