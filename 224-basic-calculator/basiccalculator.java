class Solution {
    public int calculate(String s) {
        s = s.replace(" ","");
        int[] index = new int[1];
        return helper(s,index);
    }
    private int helper(String s, int[] index){
        int sum = 0;
        char op = '+';
        while(index[0] < s.length()) {
            char cur = s.charAt(index[0]);
            if(Character.isDigit(cur)){
                int count = 0;
                while(index[0] < s.length() && Character.isDigit(s.charAt(index[0]))){
                    count = count*10 + (s.charAt(index[0]) - '0');
                    index[0]++;
                }
                if(op == '+'){
                    sum += count;
                }else{
                    sum -= count;
                }
            }else if(cur == '+' || cur == '-'){
                op = cur;
                index[0]++;
            }else if(cur == '('){
                index[0]++;
                if(op == '+'){
                    sum += helper(s,index);
                }else{
                    sum -= helper(s,index);
                }
            }else if(cur == ')'){
                index[0]++;;
                return sum;
            }
        }
        return sum;
    }
}
