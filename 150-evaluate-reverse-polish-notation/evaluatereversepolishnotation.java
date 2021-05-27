class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s: tokens){
            if(s.equals("+")){
                int temp = (int)(stack.pollFirst())+(int)(stack.pollFirst());
                stack.offerFirst(temp);
            }else if(s.equals("-")){
                int temp = stack.pollFirst()*-1+stack.pollFirst();
                stack.offerFirst(temp);
            }else if(s.equals("/")){
                int first = stack.pollFirst();
                int second = stack.pollFirst();
                int temp = (int)(second/first);
                stack.offerFirst(temp);
            }else if(s.equals("*")){
                 int temp = stack.pollFirst()*stack.pollFirst();
                stack.offerFirst(temp);
            }else{
                int temp = Integer.valueOf(s);
                stack.offerFirst(temp);
            }
        }
        return stack.pollFirst();
    }
}
