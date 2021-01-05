class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
         if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n*m];
        int x = 0;
        int y = 0;
        int index = 0;
        //代表坐标走的方向
        int direction = 1;
        while(index < m*n){
            // 1 2 3
            // 4 5 6
            // 7 8 9
            // 以下情况是为了坐标从3转到6 或者从8转到9是需要考虑的情况
            if(y >= m){
                x++;
                y--;
            }else if(x >= n){
                x--;
                y++;
            }
            while(x >= 0 && x < n && y >= 0 && y < m){
                res[index++] = matrix[x][y];
                x -= direction;
                y += direction;
            }
            if(direction == 1){
                x += direction;
            }else{
                y -= direction;
            }
            direction *= -1;
        }
        return res;
    }

}
