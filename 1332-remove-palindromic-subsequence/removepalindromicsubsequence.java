class Solution {
    public int removePalindromeSub(String s) {
        //because it's only two numbers, so max two step
        //because it's can remove  palindromic subsequence
        //ex: ababa....=> step 1, remove all b ,become two subsequence aaaa... and bbbb....
        //then two steps become empty string
        if(s.length() == 0){
            return 0;
        }
        if(isPalidrome(s)){
            return 1;
        }
        return 2;
    }
    private boolean isPalidrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
