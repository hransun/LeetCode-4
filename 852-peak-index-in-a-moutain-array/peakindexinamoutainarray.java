class Solution {
    public int peakIndexInMountainArray(int[] arr) {
      //T: O(logn)
        int left = 0;
        int right = arr.length -1;
        while(left < right -1){
            int mid = left + (right-left)/2;
            //确认mid和左右两边的关系
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
          //确认mid在有序的那一边并且有序的关系的ascending
            }else if(arr[mid] >= arr[mid-1] && arr[mid]>arr[left]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return arr[left]>arr[right]? left: right;
    }
}
