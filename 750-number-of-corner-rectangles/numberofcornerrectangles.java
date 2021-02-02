class Solution {
    public int countCornerRectangles(int[][] grid) {
        //T: M*N*M*N
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n-1; i++){
            for(int j = 0; j < m-1; j++){
                if(grid[i][j] == 1){
                    for(int k = j+1; k <m; k++){
                        if(grid[i][k] == 1){
                            for(int p = i+1; p <n; p++){
                                if(grid[p][j] == 1 && grid[p][k] == 1){
                                    res++;
                                }
                            }

                        }
                    }
                }
            }
        }
        return res;
    }
}
