class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int res = 0;
        //dummy intervals, incase the intervals is empty
        int[] cur = new int[]{-1,-1};
        for(int[] p: intervals){
            // no overlap
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
//mysolution
// sort by start or if same start, sort by descending end
// firt interval is the cur one, then compare with the later
// if cover do nothing
// if not cover res ++, update interval to the next one
public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new MyCompare());
        int res = 1;
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] temp = intervals[i];
            if(temp[0] >= cur[0] && temp[1] <= cur[1]){
                continue;
            }
            res++;
            cur = temp;
        }

        return res;
    }
    private static class MyCompare implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            if(a[0]==b[0]&&a[1]==b[1]){
                return 0;
            }
            if(a[0]==b[0] &&a[1]>b[1] || a[0]<b[0]){
                return -1;
            }
            return 1;
        }
    }
