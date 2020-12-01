class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int i = 0;
        int start = 0;
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(i < s.length()){
            char cur = s.charAt(i);
            if(!map.containsKey(cur) && map.size() == 2){
                    length = Math.max(length, i-start);
                    start = updateMap(map);
            }
            map.put(cur,i);
            i++;
        }
        length = Math.max(length, i-start);
        return length;
    }
    private int updateMap(Map<Character, Integer> map){
        int start = -1;
        Set<Character> set = map.keySet();
         List<Character> list = new ArrayList<>();
        for(Character c : set){
            list.add(c);
        }
        int in1 = map.get(list.get(0));
        int in2 = map.get(list.get(1));
        if(in1 < in2){
            map.remove(list.get(0));
            start = in1+1;
        }else{
            map.remove(list.get(1));
            start = in2+1;
        }
        return start;
    }
}
