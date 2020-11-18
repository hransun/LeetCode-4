class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> {
                      int comp = a[0]-b[0];
                      if(comp == 0){
                          comp = a[1]-b[1];
                      }
                      return comp;
                    });

        int end = intervals[0][1];
        int start = intervals[0][0];
        List<int[]> list = new ArrayList<>();
        for(int i = 1; i < intervals.length; i++){
            int[] pair = intervals[i];
            if(end < pair[0]){
                list.add(new int[]{start, end});
                start = pair[0];
            }
            end = Math.max(end, pair[1]);
        }
        list.add(new int[]{start, end});
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
