class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        //发生collion的情况是
        //  >  >  <  <
        //  5  5 -6 -9
        //只有中间的5和-6会发生冲撞
        //用stack结构
        // if "+", push to the stack
        // if " -", check the stack
        // if stack is Empty or top is " -", push to stack
        // if top is " +" && |peek.top| < |" -"|, continue pop，until empty or kill the " - "
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i: asteroids){
            if(i > 0){
                stack.offerFirst(i);
                continue;
            }
            if(i < 0){
                  //case 1: stack pop unitl empty or meet the negative number
                 while(!stack.isEmpty() && stack.peekFirst() > 0 && Math.abs(stack.peekFirst()) < Math.abs(i)){
                    stack.pollFirst();
                }
                //case 2: meeth the same value number, both destory
                //这里也承接了上面while loop情况下，stack变成empty，然后把-i放进去
                if(stack.isEmpty() || stack.peek() < 0){
                    stack.offerFirst(i);
              //case 3: meet a bigger number, do nothing
                } else if(stack.peekFirst() == Math.abs(i)){
                    stack.pollFirst();
                }

            }
        }
        //the result is the reverse result
        int size = stack.size();
        int[] res = new int[size];
        for(int i = size -1 ;i >=0; i--){
            res[i] = stack.pollFirst();
        }
        return res;
    }
}
