class Solution {
    public void solve(char[][] board) {
        //T: O(M*N*(M+N)) S: O(M+N + M*N)
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        // char[][] matrix = new char[row][col];
        // for(int i =0; i < row; i++) {
        //     for(int j = 0; j < col; j++){
        //         matrix[i][j] = 'X';
        //     }
        // }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == row-1|| j == col-1)) {
                    helper(board, i, j, row, col, visited);
                }
            }
        }

        //board = matrix;
         for(int i =0; i < row; i++) {
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && board[i][j] == 'O')
                board[i][j] = 'X';
            }
        }
    }
    private void helper(char[][] board, int i, int j, int row, int col, boolean[][] visited) {
        if(i < 0 || i >=row || j <0 ||j >= col || board[i][j] != 'O') {
            return;
        }
        if(board[i][j] == 'O') {
            if(visited[i][j]){
                return;
            }
            visited[i][j] = true;
        }
        helper(board, i+1, j, row, col,visited);
        helper(board,  i-1, j, row, col, visited);
        helper(board,  i, j+1, row, col,visited);
        helper(board, i, j-1, row, col,visited);
    }
}
