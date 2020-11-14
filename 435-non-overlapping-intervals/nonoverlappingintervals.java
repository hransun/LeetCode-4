class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //sort by start/end asending
        // prev End > cur start => delete cur interval, count++
        //prev End <= cur start  => update prevEnd to curEnd
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        if(intervals == null || intervals.length <= 1){
            return count;
        }
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            if(cur[0] < prevEnd){
                count++;
                continue;
            }
            prevEnd = cur[1];
        }
        return count;
    }
}
