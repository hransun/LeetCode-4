class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row/2; i++){
            for(int j = 0; j < col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[row-1-i][j];
                matrix[row-1-i][j] = temp;
            }
        }
        for(int i = row-1; i >= 0; i--){
            for(int j = col-1; j > i; j--){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
