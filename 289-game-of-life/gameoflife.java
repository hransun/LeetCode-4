class Solution {
    public void gameOfLife(int[][] board) {
      // s: m*n t: m*n*9
       int[][] copy = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                copy[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                int count = 0;
                int cur = board[i][j];
                for(int k = i-1; k <= i+1; k++){
                    for(int p = j-1; p <= j+1; p++){
                      //out of bound or 自身，不需要看，直接skip
                        if(k < 0 || p < 0 || k >= board.length || p >= board[0].length || (k == i && p==j)){
                            continue;
                        }
                        count += copy[k][p];
                    }
                }
                if(cur == 1 && (count < 2 || count > 3)){
                    board[i][j] = 0;
                }
                if(cur == 0 && count == 3){
                   board[i][j] = 1 ;
                }
            }
        }
    }
    //another solution without extra space
    // if 1-> 0, change cell to -1; still count 1 if the Math.abs(cell) == 1
    //if 0 -> 1, change cell to 2
    // post process, change -1 to 0, and 2 to 1


}
