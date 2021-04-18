class Solution {
    public String removeDuplicates(String s, int k) {
        int index =0;
        Deque<Pair<Character,Integer>> deque = new ArrayDeque<>();
        while(index < s.length()){
            char cur = s.charAt(index);
            if(deque.isEmpty()){
                deque.offerFirst(new Pair(cur,1));
            }else {
                Pair prev = deque.peekFirst();
                char c = (char)(prev.getKey());
                int val = (int)(prev.getValue());
                if(c == cur){
                    deque.pollFirst();
                    val++;
                    if(val < k){
                        deque.offerFirst(new Pair(cur, val));
                    }
                }else{
                    deque.offerFirst(new Pair(cur,1));
                }
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            Pair cur = deque.pollLast();
            char c = (char)(cur.getKey());
            int count = (int)(cur.getValue());
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
