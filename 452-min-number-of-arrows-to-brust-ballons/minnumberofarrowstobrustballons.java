class Solution {
    public int findMinArrowShots(int[][] points) {
        //sorted by the end point ascending
        //case1 if end > the next start do nothing
        // no matter how many overlap it will has, only can be used for two overlap, no need to update end
        //case2 if end < the next start count++ and update end
        //Integer.compare(a[1],b[1]) incase overlape
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        if(points.length == 0){
            return 0;
        }
        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length;i++){
          //no overlap
            if(end < points[i][0]){
                count++;
                end = points[i][1];
            }
        }
        return count;
    }
}
//mysolution
// sort by ascending start time and ascending end time
//interval is the array[0], count =1
// no overlap , count++, interval = cur
// has overlap, interval[1] = min of end
if(points.length == 0){
  return 0;
}
Arrays.sort(points, new MyCompare());
int[] interval = points[0];
int count = 1;
for(int i =1; i < points.length; i++){
  int[] cur = points[i];
  if(cur[0] > interval[1]){
      count++;
      interval = cur;
  }else{
      interval[1] = Math.min(interval[1], cur[1]);
  }

}
return count;
}
private static class MyCompare implements Comparator<int[]>{
@Override
public int compare(int[] a, int[] b){
  if(a[0] == b[0] && a[1] == b[1]){
      return 0;
  }
  if(a[0] < b[0] || a[0] == b[0] && a[1] < b[1]){
      return -1;
  }
  return 1;
}
}
