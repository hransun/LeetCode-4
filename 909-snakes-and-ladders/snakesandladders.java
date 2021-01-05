class Solution {
    public int snakesAndLadders(int[][] board) {
    //bfs
        // 每一个格子能最多走6步
        //走到-1， next就是-1代表的数字
        //走到数字，跳到相应的数字
        //走到n*n, return
        int n = board.length;
        //实际从1开始，所以要多算一个
        boolean[] visited = new boolean[n*n+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k = 0; k<size;k++){
                int cur = queue.poll();
                if(cur == n*n){
                    return level;
                }
                for(int i = cur+1; i < cur+7 && i <= n*n; i++){
                    //实际从index 0开始算，所以要-1
                        int index = i-1;
                    //算row
                        int x = index/n;
                    //算col
                        int y = x%2 ==0? index%n: n-1-index%n;
                    //倒过来算
                        int num = board[n-1-x][y];
                    if(num == -1){
                        num = i;
                    }
                    if(!visited[num]){
                        queue.offer(num);
                        visited[num] = true;
                    }
                }
            }

            level++;
        }
        return -1;
    }
}
