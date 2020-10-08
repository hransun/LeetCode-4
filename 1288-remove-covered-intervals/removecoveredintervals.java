class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int res = 0;
        //dummy intervals, incase the intervals is empty
        int[] cur = new int[]{-1,-1};
        for(int[] p: intervals){
            // no over lap
            if(cur[0] < p[0] && cur[1] < p[1]){
                res++;
                //update start
                cur[0] = p[0];
            }
            //update end, which shall be biggest end
            cur[1] = Math.max(cur[1],p[1]);
        }
        return res;
    }
}
