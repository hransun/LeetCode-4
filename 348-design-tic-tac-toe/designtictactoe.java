class TicTacToe {
    int[] rowLine; // mark in the row, how many marker has put
    int[] colLine;// mark in the col, how many marker has put
    int diagonal;// mark in the diagonal, how many marker has put
    int antiDia;// mark in the antiDia, how many marker has put
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowLine = new int[n];
        colLine = new int[n];
        diagonal = 0;
        antiDia = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1? -1: 1;
        rowLine[row] += add;
        colLine[col] += add;
        if(row == col){
            diagonal += add;
        }
        if(col == n-row-1){
            antiDia += add;
        }
        if(Math.abs(rowLine[row]) == n || Math.abs(colLine[col]) == n || Math.abs(diagonal) == n || Math.abs(antiDia) == n){
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
