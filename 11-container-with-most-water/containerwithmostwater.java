class Solution {
    public int maxArea(int[] height) {
        //两点之间的高柱子可以移掉
        //area = Math.min(leftbound, rightbound)*distance
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left < right){
            res = Math.max(res, Math.min(height[left],height[right])*(right-left));
            //移动矮的那一边
            if(height[left] <= height[right]){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}
