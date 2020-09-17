class Solution {
    //无限循环，要么i==0 && 就== 0 ，要么和原来的初始方向不一致
    //这里没有call back，所以不需要用dfs
     public boolean isRobotBounded(String instructions) {
        char[] array = instructions.toCharArray();
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
         int i =0;
         int j = 0;
         int dir = 0;
        for(char c: instructions.toCharArray()){
            if(c == 'L'){
                dir = (dir+3)%4;
            }else if(c == 'R'){
                dir = (dir+1)%4;
            }else{
                 i += direction[dir][0];
                j += direction[dir][1];
            }
        }
        return i==0 && j == 0 || dir != 0;
    }

}
