class Solution {
    public int findCircleNum(int[][] isConnected) {
        //union find: find how many parent(即id== -1)
        // initally id[]
        // union x, y if matrix[x][y] == 1
        // implment find found in the union method
        //T: n^2 S: O(n)
        int n = isConnected.length;
        int[] id = new int[n];
        Arrays.fill(id, -1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    union(i,j,id);
                }
            }
        }
        int res = 0;
        for(int i: id){
            if(i == -1){
                res++;
            }
        }
        return res;
    }
    private void union(int x, int y, int[] id){
        int id1 = find(x, id);
        int id2 = find(y, id);
        //x,y not connect, then connect them together
        if(id1 != id2){
            id[id1] = id2;
        }
    }
    private int find(int x, int[] id){
        //x本身就是root
        if(id[x] == -1){
            return x;
        }
        //recursion的方法找到parent
        return find(id[x],id);
    }
}
