class Solution {
    public int minAddToMakeValid(String s) {
        //T: O(n)
        if(s== null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int res = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                left++;
            }else {
                if(left > 0) {
                    left--;
                }else {
                    res++;
                }
            }
        }
        res += left;
        return res;

    }
}
