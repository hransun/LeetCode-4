class Solution {
     //T： N^ 4
    //计算出每一个A中的1到每一个B中1的位置
    //计算方法： (x1 - x2, y1- y2)
    // 位移的重复的次数最多就是重复的数
    //如果重复，位移次数应该是相等的，即cell是相等的，所有找到cell对应最多的value即可
    public int largestOverlap(int[][] A, int[][] B) {
       Map<Cell, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j =0; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    for(int k = 0; k < A.length; k++) {
                        for(int p = 0; p < A.length; p++) {
                            if(B[k][p] == 1) {
                                int x = i - k;
                                int y = j - p;
                                Cell cell = new Cell(x,y);
                                map.put(cell, map.getOrDefault(cell, 0)+1);
                                res = Math.max(map.get(cell), res);
                            }
                        }
                    }
                }
            }
        }
       return res;
    }
    static class Cell{
        int x;
        int y;
        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return x == cell.x &&
                    y == cell.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }
}
