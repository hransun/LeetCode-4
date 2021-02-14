class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        //bfs
        //T: O(m*m)
        int distance = 1;
        int n = grid.length;
        int m = grid[0].length;
        //corner case: the beginngin position is 1 => no way to get the result
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair(0,0));
        grid[0][0] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Pair cur = queue.poll();
                int x = (int)cur.getKey();
                int y = (int)cur.getValue();
                if( x== n-1 &&  y== m-1){
                    return distance;
                }
                for(int k = -1; k <= 1; k++){
                    for(int p = -1; p <= 1; p++){
                        if(x+k>= 0 && x+k<n && y+p >=0 && y+p<m && grid[x+k][y+p]==0){
                            queue.offer(new Pair(x+k,y+p));
                            grid[x+k][y+p] = 1;
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}
