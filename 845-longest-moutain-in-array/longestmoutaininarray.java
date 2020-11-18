class Solution {
    public int longestMountain(int[] A) {
      //T:o(n) S:o(1)
      //从第一个index开始出发找moutain patter
      //如果有moutan patter, 下一轮从i+ cur-1出发
      //如果没有，index++；
        int res = 0;
        int i = 0;
        while(i < A.length-2){
            int cur= getLength(A,i);
            res= Math.max(res, cur);
            if(cur > 0){
                i = (i + cur-1);
            }else{
                i++;
            }
        }
        return res;
    }
    private int getLength(int[] array, int index){
        int length = 1;
        boolean moutain = false;
        while(index < array.length-1 &&  array[index+1]>array[index]){
                index++;
                length++;
        }
        if(index < array.length-1 && array[index] == array[index+1]){
                return 0;
        }
        if(index < array.length-1 &&array[index] > array[index+1] && length > 1){
                moutain = true;
        }
        while(index< array.length-1 && array[index] > array[index+1] && moutain == true){
                index++;
                length++;
        }
        if(moutain == false){
            return 0;
        }
        return length == 1? 0: length;
    }
}
