class Solution {
    public int numDistinctIslands(int[][] grid) {
     //T: O(n*m)
        //S: O(m*n)
        // step1 dfs,and get all the relative cornidates
        //ex:
        //1 0 1
        //1 0 1
        // dfs get two distance island {0,0 /1,0} and {0,2/ 1,2}
        // the ralative cornidates is {0,0 /1,0} and {0,0 /1,0}
        //so it's the same, return 1
        //here using hashset to check duplicated
        // Pair(key, value) => has the equals function
        // Pair p = new Pair(Integer, Integer)
        Set<Set<Pair<Integer, Integer>>> res = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    // the cornidate hashset for the cur island
                    Set<Pair<Integer,Integer>> cur = new HashSet<>();
                    dfs(grid,n,m,i,j,cur,i,j);
                    // if(!equals(cur,res)){
                    //     res.add(cur);
                    // }
                    res.add(cur);
                }
            }
        }
        return res.size();
    }
    private void dfs(int[][] grid, int n, int m, int x, int y, Set<Pair<Integer, Integer>> set,int org_x, int org_y){
        if(x < 0 || x >= n || y < 0|| y>=m || grid[x][y] == 0){
            return;
        }
        //store the relative cornidate
        set.add(new Pair(x-org_x,y-org_y));
        grid[x][y] = 0;
        dfs(grid,n,m,x-1,y,set,org_x,org_y);
        dfs(grid,n,m,x+1,y,set,org_x,org_y);
        dfs(grid,n,m,x,y-1,set,org_x,org_y);
        dfs(grid,n,m,x,y+1,set,org_x,org_y);
    }
    private boolean equals(Set<int[]> cur, Set<Set<int[]>> set){
        for(Set<int[]> s: set){
            if(match(s, cur)){
                return true;
            }
        }
        return false;
    }
    private boolean match(Set<int[]> s1, Set<int[]> s2){
        for(int[] pair: s1){
            if(!s2.contains(pair)){
                return false;
            }
        }
        return true;
    }
}
