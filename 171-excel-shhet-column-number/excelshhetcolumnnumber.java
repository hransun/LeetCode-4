class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int size = s.length();
        for(int i = 0; i < size; i++){
            res += (int)Math.pow(26.00, (size-i-1)*1.00)*(s.charAt(i) - 'A'+1);
        }
        return res;
    }
}
