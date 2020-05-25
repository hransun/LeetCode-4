class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // merge interval
        // T: O(n+m) S: O(1)
            if(A == null || B == null || A.length == 0 || B.length == 0) {
                return new int[][]{};
            }
            List<int[]> list = new ArrayList<>();
            int i = 0;
            int j = 0;
            while(i < A.length && j <B.length) {
                int start = Math.max(A[i][0],B[j][0]);
                int end = Math.min(A[i][1],B[j][1]);
                if(start <= end) {
                    list.add(new int[]{start,end});
                }
                if(A[i][1] < B[j][1]) {
                    i++;
                }else{
                    j++;
                }

            }
        return list.toArray(new int[list.size()][]);
    }
}
