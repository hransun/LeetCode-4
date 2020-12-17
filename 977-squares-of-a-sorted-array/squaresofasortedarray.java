class Solution {
    public int[] sortedSquares(int[] nums) {
        int right = binarySearch(nums);
        if(right == -1){
            right = nums.length -1;
        }
        int left = right -1;
        int[] res = new int[nums.length];
        int index = 0;
        while(left >= 0 && right < nums.length){
            int a = nums[right]*nums[right];
            int b = nums[left]*nums[left];
            if(a <= b){
                res[index++] = a;
                right++;
            }else{
                res[index++] = b;
                left--;
            }
        }
        while(left >= 0){
            res[index++] = nums[left]*nums[left];
            left--;
        }
        while(right < nums.length){
            res[index++] = nums[right]*nums[right];
            right++;
        }
        return res;
    }
    private int binarySearch(int[] nums){
        int left = 0;
        int right = nums.length -1;
        while(left < right-1){
            int mid = left + (right - left)/2;
            if(nums[mid] < 0){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        if(nums[left] >= 0){
            return left;
        }
        if(nums[right] >= 0){
            return right;
        }
        return -1;
    }

}
