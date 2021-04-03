class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        //pre[1]: number of pre of num 1 course
        int[] pre = new int[n+1];
        for(int[] pair: relations){
            int course = pair[1];
            pre[course]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            //no prerequestion class
            if(pre[i] == 0){
                queue.offer(i);
            }
        }
        //for loop situation
        if(queue.size() == 0){
            return -1;
        }
        int level = 0;
        Set<Integer> taken = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                taken.add(cur);
                for(int[] pair: relations){
                    if(pair[0] == cur){
                        int course = pair[1];
                        pre[course]--;
                        if(pre[course] == 0){
                            queue.offer(course);
                        }
                    }
                }
            }
            level++;
        }
        //check whether all the courses have been taken
        return taken.size() == n? level:-1;
    }
}
