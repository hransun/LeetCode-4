class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int i = findFirst(nums,target);
        int j = findLast(nums,target);
        return new int[]{i,j};
    }
    private int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left < right-1){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target) {
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        if(nums[left]== target){
            return left;
        }
        if(nums[right] == target){
            return right;
        }
        return -1;
    }
    private int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left < right-1){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                left = mid;
            }else if(nums[mid] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }

        }
        if(nums[right] == target){
            return right;
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }
}
