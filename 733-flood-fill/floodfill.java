class Solution {
    //T: O(n *m) S: O(n*m)
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int row = image.length;
        int col = image[0].length;
        if(sr >= row || sc >= col) {
            return image;
        }
        int target = image[sr][sc];
        helper(image, sr,sc, newColor, target, row, col);
        return image;
    }
    private void helper(int[][] image, int i, int j, int newColor, int target, int row, int col) {
        if(i >= row || j >= col || i < 0 || j < 0 || image[i][j] != target || image[i][j] == newColor) {
            return;
        }
            image[i][j] = newColor;
            helper(image, i+1, j, newColor, target, row, col);
            helper(image, i, j+1, newColor, target, row, col);
            helper(image, i-1, j, newColor, target, row, col);
            helper(image, i, j-1, newColor, target, row, col);
    }

}
