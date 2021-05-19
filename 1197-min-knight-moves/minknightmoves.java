class Solution {
    public int minKnightMoves(int x, int y) {
        int step = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0});
        //这里需要用int[][]，用set会超时
        // x=300, y= 0 => next: 302: 2 => boolean start from 0, so the range is 605
        // and middle is 302
        boolean[][] visited = new boolean[605][605];
        visited[302][302] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if(i == x && j == y){
                    return step;
                }

                for(int k = -2; k <= 2; k += 2){
                    for(int p = -1; p <= 1; p++)
                    if(k != 0 && p != 0){
                        if(!visited[i+k+302][j+p+302]){
                            queue.offer(new int[]{i+k, j+p});
                            visited[i+k+302][j+p+302] = true;
                        }
                        if(!visited[i+p+302][j+k+302]){
                            queue.offer(new int[]{i+p, j+k});
                            visited[i+p+302][j+k+302] = true;
                        }

                    }
                }
            }
            step++;
        }
        return -1;
    }
}
