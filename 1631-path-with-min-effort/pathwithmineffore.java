class Solution {
    public int minimumEffortPath(int[][] heights) {
        //bfs
        //min heap(x,y, the min of (the set of max consecutive differ of the path that end at this node))
        //start from the min heap
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2] - b[2]);
        //用于存之前path走到这个node的时候的最大diff
        int[][] maxDiff = new int[n][m];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ;j< m; j++){
                maxDiff[i][j] = Integer.MAX_VALUE;
            }
        }
        maxDiff[0][0] = 0;
        boolean[][] visited = new boolean[n][m];
        minHeap.offer(new int[]{0,0,maxDiff[0][0]});
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int x = cur[0];
            int y = cur[1];
            int curDiffer = cur[2];
            visited[x][y] = true;
            if(x == n-1 && y == m -1){
                return curDiffer;
            }
            if(x-1 >= 0 && !visited[x-1][y]){
              //计算当前路径下，在当前元素结束的时候，这条路径上的最大 max consecutive diff
                int maxDiffer = Math.max(curDiffer,Math.abs(heights[x-1][y]-heights[x][y]));
                //跟新这个cell在不同path的情况下最小的diff
                maxDiff[x-1][y] = Math.min(maxDiff[x-1][y], maxDiffer);
                //这里对同一个坐标重复存没有关系，因为是最后是看diff大小general出来，diff越小越早general
                minHeap.offer(new int[]{x-1,y,maxDiff[x-1][y]});
            }
            if(x+1 < n && !visited[x+1][y]){
                int maxDiffer = Math.max(curDiffer,Math.abs(heights[x+1][y]-heights[x][y]));
                maxDiff[x+1][y] = Math.min(maxDiff[x+1][y], maxDiffer);
                minHeap.offer(new int[]{x+1,y,maxDiff[x+1][y]});
            }
            if(y+1 < m && !visited[x][y+1]){
                int maxDiffer = Math.max(curDiffer,Math.abs(heights[x][y+1]-heights[x][y]));
                maxDiff[x][y+1] = Math.min(maxDiff[x][y+1],maxDiffer);
                minHeap.offer(new int[]{x,y+1,maxDiff[x][y+1]});
            }
            if(y-1 >= 0 && !visited[x][y-1]){
                int maxDiffer = Math.max(curDiffer,Math.abs(heights[x][y-1]-heights[x][y]));
                maxDiff[x][y-1] = Math.min(maxDiff[x][y-1], maxDiffer);
                minHeap.offer(new int[]{x,y-1,maxDiff[x][y-1]});
            }
        }
        return -1;
    }
}
