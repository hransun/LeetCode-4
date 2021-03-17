class Solution {
    public int scoreOfParentheses(String S) {
        //recursion
        //T: O(n) -best case ((())) O(n^2) - worse case ()()()
        //base case :()
        //recursion rule, if it's not balance recursion 1 () + recursion 2(())
        return helper(S, 0, S.length()-1);

    }
    private int helper(String S, int left, int right){
        //base case
        if(left + 1 == right){
            return 1;
        }
        //how many left parenthese
        int leftP = 0;
        //go until the one before last index, just for check this substring is balanced or not
        for(int i = left; i < right-1; i++){
            if(S.charAt(i) == '('){
                leftP++;
            }else{
                leftP--;
            }
            // the situation ()(()) happens
            if(leftP == 0){
                return helper(S, left, i) + helper(S, i+1, right);
            }
        }
        //go there, mean this substring is balance (())
        return 2*helper(S, left+1, right-1);

    }
}
