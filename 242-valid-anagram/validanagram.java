class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            int val = map.get(c)-1;
            if(val == 0){
                //map. remove --> average time complexity is o(1), worse is o(n) with collison
                map.remove(c);
            }else{
                map.put(c, val);
            }
        }
        return map.size() == 0;

    }
}
