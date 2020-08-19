class Solution {
    public int[] findPermutation(String s) {
        // n = s.length+1;
        // index i = 1 to s.length
        //因为从小到大排列
        // if meet i: put index into stack, 再把stack poll干净
        // if meet D： put into stack until meet i again， 把meet i的index也要放到stackzhong
        // 然后从stack中poll完所有的数字，那么从第一个d到第一个i之间的顺序是降序
        //post-processing:最后多出来的格子当成i，
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[s.length()+1];
        int j =0;
        for(int i =1; i <=s.length()+1; i++){
            if(i == s.length()+1 || s.charAt(i-1) == 'I') {
                stack.offerFirst(i);
                while(!stack.isEmpty()) {
                    res[j++] = stack.pollFirst();
                }
            }else if(s.charAt(i-1) == 'D'){
                stack.offerFirst(i);
            }
        }
        return res;
    }
}
