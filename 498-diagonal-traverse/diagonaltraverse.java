class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
      //T: O(N) S: O(1)
         if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int[] res = new int[n*m];
        int x = 0;
        int y = 0;
        int index = 0;
        //代表坐标走的方向
        int direction = 1;
        while(index < m*n){
            //进入这个loop的时候x，y一定都会在有效范围内
            while(x >= 0 && x < n && y >= 0 && y < m){
                res[index++] = matrix[x][y];
                x -= direction;
                y += direction;
            }
            //out of bound，需要处理两种情况
            if(direction == 1){
                //当x,y都出界的时候，需要退回到原来一步
                if(y >= m){
                    y -= direction;
                    x += direction;
                }
                x += direction;

            }else{
                ////当x,y都出界的时候，需要退回到原来一步
                if(x >= n){
                    x += direction;
                    y -= direction;
                }
                y -= direction;
            }
            direction *= -1;
        }
        return res;
    }

}
//additional space
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        // if in the same diagonal, i+j is the same
        // Map<i+j,deque>
        if(matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0;j<matrix[0].length; j++){
                if(!map.containsKey(i+j)){
                    map.put((i+j), new ArrayDeque<>());
                }
                map.get(i+j).offerFirst(matrix[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < matrix[0].length; i++){
            int j = 0;
            Deque<Integer> deque = map.get(i+j);
            if((i+j)%2 == 1) {
                while(!deque.isEmpty()){
                    list.add(deque.pollLast());
                }
            }else{
                 while(!deque.isEmpty()){
                     list.add(deque.pollFirst());
                 }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            int j = matrix[0].length-1;
            Deque<Integer> deque = map.get(i+j);
            if((i+j)%2 == 1) {
                while(!deque.isEmpty()){
                    list.add(deque.pollLast());
                }
            }else{
                 while(!deque.isEmpty()){
                     list.add(deque.pollFirst());
                 }
            }
        }
        int[] res = new int[matrix.length*matrix[0].length];
        int index = 0;
        for(int i: list){
            res[index++] = i;
        }
        return res;
    }
}
