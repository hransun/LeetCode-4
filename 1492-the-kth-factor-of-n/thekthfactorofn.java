class Solution {
    public int kthFactor(int n, int k) {
        //for loop from 1 to N, count the number of factor
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n%i == 0){
                count++;
            }
            if(count == k){
                return i;
            }
        }
        return -1;
    }
}
