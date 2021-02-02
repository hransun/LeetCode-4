class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        //除第一个nut之外，所有的nut的距离是nut到tree的距离*2
        //只有一个nut的距离是nut到tree + nut到squirrel
        // all dis = 所有nut到tree的距离*2 - max（nut到tree距离 - nut到squirrle距离的差值
        int res = 0;
        int diff = Integer.MIN_VALUE;
        for(int[] pair: nuts){
            res += (distance(pair, tree)*2);
            diff = Math.max(diff, distance(pair,tree) - distance(pair, squirrel));
        }
        return res-diff;
    }
    private int distance(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+ Math.abs(a[1]-b[1]);
    }
}
