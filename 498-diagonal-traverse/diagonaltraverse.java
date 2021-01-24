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
            //进入这个loop的时候x，y一定都会在有效范围内
            while(x >= 0 && x < n && y >= 0 && y < m){
                res[index++] = matrix[x][y];
                x -= direction;
                y += direction;
            }
            //out of bound，需要处理两种情况
            if(direction == 1){
                //当x,y都出界的时候，需要退回到原来一步
                if(y >= m){
                    y -= direction;
                    x += direction;
                }
                x += direction;

            }else{
                ////当x,y都出界的时候，需要退回到原来一步
                if(x >= n){
                    x += direction;
                    y -= direction;
                }
                y -= direction;
            }
            direction *= -1;
        }
        return res;
    }

}
