class Solution {
    public int longestPalindrome(String s) {
        //T: O(n) S: O(n)
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd = false;
        int sum = 0;
        for(int i : map.values()) {
            sum +=(i/2)*2;
            if(!odd && i%2 == 1){
                odd = true;
            }
        }
        return odd== true? sum+1: sum;
    }
}
