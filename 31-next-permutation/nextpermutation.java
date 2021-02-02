class Solution {
    public void nextPermutation(int[] A) {
        //T: O(n)
        //下一个permuatation
        //XXXY DES -> XXXZ ACS 其中z比y大一号
        //step1: 找到DES range， i停在Y上,这里有重复的元素也可以视为des
        //step2: 在DES中找到the smallest element that bigger than Y，这里是j
        //step3: swap i，j， 此时DES的部分仍旧是des
        //step 4: 把DES变成ASC

        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        //step1
        while(i >= 0 && A[i] >= A[i + 1]) i--;
        //if i < 0 => the whole array is DES
        if(i >= 0) {
            //step 2
            int j = A.length - 1;
            while(A[j] <= A[i]) j--;
            //step 3
            swap(A, i, j);
        }
        //step 4
        reverse(A, i + 1, A.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
}
//better time complexity using binary search
class Solution {
    public void nextPermutation(int[] nums) {
      //step 1
        int target = -1;
        for(int i = nums.length -2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                target = i;
                break;
            }
        }
        if(target >= 0){
            int swapIndex = binarySearch(nums, target+1, nums[target]);
            int temp = nums[swapIndex];
            nums[swapIndex] = nums[target];
            nums[target] = temp;
        }
        reverse(nums, target+1, nums.length-1);

    }
    //step 2
    private int binarySearch(int[] array, int i, int target){
        int j = array.length -1;
        while(i < j-1){
            int mid = i + (j-i)/2;
            if(array[mid] > target){
                i = mid;
            }else{
                j = mid-1;
            }
        }
        if(array[j] > target){
            return j;
        }
        return i;
    }
    //step 3
    private void reverse(int[] array, int start, int end){
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
