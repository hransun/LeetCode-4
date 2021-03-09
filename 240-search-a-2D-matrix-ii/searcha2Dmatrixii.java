class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start from left-bottom pointer
        // look for bigger num ==> go right
        // look for small num == > go up
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n-1;
        int y = 0;
        //x 和 y不会超另外一边的界
        //因为小的只会往上走，大的只会往右走
        while(x >= 0 && y < m ){
            int cur = matrix[x][y];
            if(cur == target){
                return true;
            }
            if(cur > target){
                x--;
            }else{
                y++;
            }
        }
        return false;
    }
}
