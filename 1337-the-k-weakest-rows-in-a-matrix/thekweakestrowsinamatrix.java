class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<Pair<Integer, Integer>> min = new PriorityQueue<>((a,b) -> {
            int comp = a.getKey()- b.getKey();
            if(comp == 0){
                comp = (int)(a.getValue()-b.getValue());
            }
            return comp;
        });
        for(int i = 0; i < mat.length; i++){
            int size =0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    size++;
                }
            }
            min.offer(new Pair(size,i));
        }
        for(int i = 0; i < k; i++){
            res[i] = (int)min.poll().getValue();
        }
        return res;
    }
}
