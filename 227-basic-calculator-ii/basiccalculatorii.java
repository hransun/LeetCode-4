class Solution {
    public int calculate(String s) {
      //T: O(n) S: O(n)

        s = s.replace(" ","");
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int digit = 0;
        char op = '+';
        while(index < s.length()){
            char cur = s.charAt(index);
            if(Character.isDigit(cur)){
                digit = 0;
                while(index < s.length() && Character.isDigit(s.charAt(index))){
                    digit = digit*10 + (s.charAt(index)-'0');
                    index++;
                }
                 if(op == '+'){
                    stack.offerLast(digit);
                }else if(op == '-'){
                    stack.offerLast(digit*-1);
                }else if(op == '*'){
                    int prev = stack.pollLast();
                    int sum = prev*digit;
                    stack.offerLast(sum);
                }else{
                    int prev = stack.pollLast();
                    int sum = prev/digit;
                    stack.offerLast(sum);
                }
            }else{
              op = cur;
            }
        }
        int res = 0;
        for(int i: stack){
            res += i;
        }
        return res;
    }
