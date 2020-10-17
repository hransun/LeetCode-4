class Solution {
    public String removeDuplicateLetters(String s) {
        //stack:keep the last letter from decending lexi order
        //case 1: pop up the peek letter
       // if peek > cur && peek letter is not the last one here, the peek letter will appear later
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length();i++){
            int index = s.charAt(i) - 'a';
            lastIndex[index] = i;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(visited[c-'a']){
                continue;
            }
            //这里需要用while loop 确保peek的值比将来要加入的值小
            while(!stack.isEmpty() && stack.peekFirst() > c && i < lastIndex[stack.peekFirst()-'a']){
                visited[stack.peekFirst()-'a'] = false;
                stack.pollFirst();
            }
            visited[c-'a'] = true;
            stack.offerFirst(c);
        }
        //reverse the order from stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.reverse().toString();


    }
}
