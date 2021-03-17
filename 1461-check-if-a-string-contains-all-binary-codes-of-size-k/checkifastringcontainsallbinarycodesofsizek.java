class Solution {
    public boolean hasAllCodes(String s, int k) {
        //check the number of unique substring of k length
        // 2^k is the number of unique binary code
        Set<String> set = new HashSet<>();
        for(int i = 0; i <= s.length()-k; i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() >= (int)Math.pow(2,k);
    }
}
