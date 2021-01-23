class Solution {
    public String longestPalindrome(String s) {
        //T: O(n^2)
        int start = 0;
        int end = 1;
        for(int i = 0; i < s.length();i++){
            //check palindrome from centry ie XXX or from pair XXXX

            int length = Math.max(findP(s,i,i), findP(s, i,i+1));
            if(length > end-start){
                start = i -(length-1)/2;
                end = start + length;
            }
        }
        return s.substring(start,end);
    }
    private int findP(String s, int i, int j){
        int length = 0;
        if(i == j){
            length = 1;
            i--;
            j++;
        }

        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                break;
            }
            length += 2;
            i--;
            j++;
        }
        return length;
    }
}
