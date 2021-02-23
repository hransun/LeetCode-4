class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        Deque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c == '(' ){
                stack.offerFirst(new Pair(c, index++));
                sb.append(c);
            }else if(c == ')'){
                if(!stack.isEmpty() &&stack.peekFirst().getKey() == '('){
                    stack.pollFirst();
                    sb.append(c);
                    index++;
                }
            }else{
                sb.append(c);
                index++;
            }
        }
        while(!stack.isEmpty()){
            int i = (int)stack.pollFirst().getValue();
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}
