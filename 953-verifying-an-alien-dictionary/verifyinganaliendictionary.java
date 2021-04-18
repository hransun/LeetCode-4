class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //word 和word之间符合 order即可，word本身的字母排序为所谓
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i),i);
        }
        String prev = words[0];
        for (int i = 1; i < words.length; i++){
            if(isOrder(prev, words[i], map)){
                prev = words[i];
            }else{
                return false;
            }
        }
        return true;

    }
    private boolean isOrder(String prev, String cur, Map<Character,Integer> map){
        int index = 0;
        while(index < prev.length() && index < cur.length()){
            if(map.get(prev.charAt(index)) > map.get(cur.charAt(index))){
                return false;
            }else if ( map.get(prev.charAt(index)) == map.get(cur.charAt(index))){
               index++;
            }else{
                return true;
            }
        }
        return prev.length() <= cur.length();
    }

}
