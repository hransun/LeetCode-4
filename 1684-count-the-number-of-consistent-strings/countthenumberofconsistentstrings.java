class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        //T: O(n) S: O(26) => max 26 letters
        Set<Character> set = new HashSet<>();
        for(char c: allowed.toCharArray()){
            set.add(c);
        }
        int res = 0;
        for(String s: words){
            boolean dup = false;
            for(char c: s.toCharArray()){
                if(!set.contains(c)){
                    dup = true;
                    break;

                }
            }
            if(!dup){
                res++;
            }
        }
        return res;
    }
}
