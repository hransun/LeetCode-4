class Solution {
    public int[][] diagonalSort(int[][] mat) {
        //All cells in the same diagonal (i,j) have the same difference
        //map< diffe of i-j: priorityqueue<mat[i][j]>
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(!map.containsKey(i-j)){
                    map.put((i-j), new PriorityQueue<>());
                }
                map.get(i-j).offer(mat[i][j]);
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }
}
