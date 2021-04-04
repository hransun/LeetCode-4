class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.offerFirst(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peekFirst()) == '('){
                stack.pollFirst();
                 res = Math.max(res, i - stack.peekFirst());
            }else{
                stack.offerFirst(i);
            }

        }
        return res;
    }
}
