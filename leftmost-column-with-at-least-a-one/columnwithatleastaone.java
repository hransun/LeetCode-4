/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        //T：rowlogcol S： O（1）
        int ans = -1;
        if(binaryMatrix == null){
            return ans;
        }
        List<Integer> size = binaryMatrix.dimensions();
        int row = size.get(0);
        int col = size.get(1);
        if(row == 0 || col == 0) {
            return ans;
        }
        ans= Integer.MAX_VALUE;
        for(int i = 0; i < row; i++ ) {
            int index = findFirstOne(binaryMatrix, i, col, 1);
            if(index >= 0) {
                ans = Math.min(ans, index);
            }
        }
        return ans == Integer.MAX_VALUE? -1 : ans;
    }
    private int findFirstOne(BinaryMatrix binaryMatrix, int row, int col, int target) {
        int i = 0;
        int j = col -1;
        while(i< j -1) {
            int m = i + (j-i)/2;
            if(binaryMatrix.get(row,m) == target) {
                j = m;
            }else {
                i = m + 1;
            }
        }
        if(binaryMatrix.get(row,i) == target) {
            return i;
        }
        if(binaryMatrix.get(row,j) == target) {
            return j;
        }
        return -1;
    }

    //Soulution 2
    //T: O(m+n) S:O(1)
    int i = 0;
    int j = col -1;
    while(i < row && j >= 0) {
         //update ans
        // if node == 1 ==> go left to find out the first 1
    if(binaryMatrix.get(i,j) == 1) {

          ans = Math.min(j, ans);
          j--;
        // if node == 0 ==> go down to find the first 1 in the next row
          }else {
               i++;
          }
       }
    return ans == Integer.MAX_VALUE? -1 : ans;
}
