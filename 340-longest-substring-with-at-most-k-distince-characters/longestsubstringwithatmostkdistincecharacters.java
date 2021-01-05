class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      //sliding widow
        if(k == 0){
            return 0;
        }
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 1;
        while(j < s.length()){
            char cur = s.charAt(j);
            if(!map.containsKey(cur) && map.size() == k ){
                while(map.size() == k){
                    char prev = s.charAt(i);
                    if(map.get(prev) == i){
                        map.remove(prev);
                    }
                    i++;
                }
            }
            map.put(cur,j);
            res = Math.max(res, (j-i+1));
            j++;
        }
        return res;
    }
}
