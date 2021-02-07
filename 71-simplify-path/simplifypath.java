class Solution {
    public String simplifyPath(String path) {
        //遇到。。 poll出
        //遇到。或者空，不用放到deque里
        //ex： /。。HOME/==》 /。。home
        String[] array = path.split("/");
        Deque<String> deque = new ArrayDeque<>();
        for(String s: array){
            if(s.equals(".") || s.length() == 0){
                continue;
            }else if(s.equals("..")){
                if(!deque.isEmpty()){
                    deque.pollFirst();
                }

            }else {
                deque.offerFirst(s);
            }
        }
        if(deque.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
