class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c == ')'){
                if(stack.isEmpty() || stack.pollFirst() != '('){
                    return false;
                }
            }else if(c ==']'){
                if(stack.isEmpty() || stack.pollFirst() != '['){
                    return false;
                }
            }else if(c == '}'){
                if(stack.isEmpty() || stack.pollFirst() != '{'){
                    return false;
                }
            }else{
                stack.offerFirst(c);
            }
        }
        return stack.isEmpty();
    }
}
