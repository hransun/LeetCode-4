class Solution {
    public int[][] candyCrush(int[][] board) {
        //if can crash, mark the val as -1
        int n = board.length;
        int m = board[0].length;
        boolean crash = true;
        while(crash){
            crash = false;
            for(int i = 0; i < n; i++){
                for(int j = 0 ; j <m; j++){
                    int val = board[i][j];
                    if(val != 0){
                        //一个个element查他右边和下边是否有连续的三个数可以crash，并标界为负数
                        boolean r1 = checkRow(i,j,n,m,board);
                        boolean r2 = checkCol(i,j,n,m, board);
                        if(r1 || r2){
                            crash = true;
                        }
                    }
                }
            }
            //change negative to 0
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(board[i][j] < 0){
                        board[i][j] = 0;
                    }
                }
            }
            if(crash){
                    updateBoard(board, n, m);
            }
        }
        return board;
    }
    private boolean checkRow(int x, int y, int n, int m, int[][] board){
        int target = Math.abs(board[x][y]);
        if(x+2 < n && Math.abs(board[x+1][y]) == target && Math.abs(board[x+2][y]) == target){
            board[x][y] = target*-1;
            board[x+1][y] = target*-1;
            board[x+2][y] = target*-1;
            return true;
        }
        return false;
    }
    private boolean checkCol(int x, int y, int n, int m ,int[][] board){
        int target = Math.abs(board[x][y]);
        if(y+2 < m && Math.abs(board[x][y+1]) == target && Math.abs(board[x][y+2]) == target){
            board[x][y] = target*-1;
            board[x][y+1] = target*-1;
            board[x][y+2] = target*-1;
            return true;
        }
        return false;
    }
    private void updateBoard(int[][] board, int n, int m){

        for(int i = 0; i < m; i++){
            int end = -1;
            int start = -1;
            for(int j = 0; j < n; j++){
                if(board[j][i] == 0){
                    if(start == -1){
                        start = j;
                    }
                    end = j;
                }else if(board[j][i] != 0 && start != -1){
                    updateCol(board,i,end,start);
                    start = -1;
                    end = -1;
                }
            }
            if(end == n-1){
                updateCol(board,i,n-1,start);
            }
        }
    }
    private void updateCol(int[][] board, int i, int end, int start){
        int offSet = start-1;
        while(offSet >= 0){
            int org = board[end][i];
            int newVal = board[offSet][i];
            board[end][i] = board[offSet][i];
            end--;
            offSet--;
        }
        while(end >= 0){
            board[end--][i] = 0;
        }
    }

}
