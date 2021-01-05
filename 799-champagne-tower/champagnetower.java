class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
      //最多多算一层
      //建立n*n的matrix
        double[][] array = new double[query_row+2][query_row+2];
        array[0][0] = poured*1.0;
        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= i ; j++){
              //留到下一层的酒的数量
                double left = (array[i][j]-1.0)/2;
                //如果有剩下，计算下一层酒的数量
                if(left > 0){
                  //ie 第一层的酒会流向第二层的0和1position的酒杯
                    array[i+1][j] += left;
                    array[i+1][j+1] += left;
                }
            }
        }
        //防止，这一层的酒是多的，所以要和1比较
        return Math.min(1, array[query_row][query_glass]);
    }
}
