class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++){
            map.put(keyboard.charAt(i),i);
        }
        int res = 0;
        int prev = 0;
        for(char c: word.toCharArray()){
            int index = map.get(c);
            res +=Math.abs(index-prev);
            prev = index;
        }
        return res;
    }
}
