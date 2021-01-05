class Solution {
    public int longestMountain(int[] A) {
      //T:o(n) S:o(1)
      //从第一个index开始出发找moutain patter
      //如果有moutan patter, 下一轮从i+ cur-1出发
      //如果没有，index++；
      //T: O(n) S: O(1)
        //i,j sliding window
        int length = 0;
        for(int i = 0; i < A.length-1; i++){
            boolean increase = false;
            boolean decrease = false;
            int j = i+1;
            int target = A[i];
            while(j < A.length && A[j] > target){
                increase = true;
                target = A[j];
                j++;
            }
            while(j<A.length && A[j] < target){
                decrease = true;
                target = A[j];
                j++;
            }
            //注意这里的j已经移动到一下个index，所以算距离要先j--
            if(increase && decrease){
                length = Math.max(length, (j-1)-i+1);
            }
        }
        return length;
}
