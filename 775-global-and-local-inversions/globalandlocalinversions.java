class Solution {
    public boolean isIdealPermutation(int[] A) {
        // a local inversion must be a global inverstion
        //however a global inversion is not a local inversion
        // we just need to check whether there has the additional global inverstion in the scope of
        // i+2 to the end
        // T: O(n) S: O(1)
        // scan from the last, and keep a min value
        int min = A.length-1;
        for(int i = A.length-1; i>= 2; i--){
            min= Math.min(A[i], min);
            //additional global inversion appears
            if(A[i-2] > min){
                return false;
            }
        }
        return true;
    }
}
