class Solution {
    public int countSubstrings(String s) {
        int res =0;
        for(int i = 0; i < s.length(); i++){
            res += checkPalin(s,i,i);
            res += checkPalin(s,i,i+1);
        }
        return res;
    }
    private int checkPalin(String s, int start, int end){
        int res = 0;
        if(start < 0 || end >= s.length()){
            return res;
        }
        while(start >= 0 && end < s.length() ){
            if(s.charAt(start) == s.charAt(end)){
                start--;
                end++;
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}
