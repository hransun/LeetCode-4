class Solution {
    public int countPrimes(int n) {
        //T:n*logn*logn => need match approve
        //S:O(n)
        // array[i] = 1 => i is prime
        // if the number is primes, the its multiple must not be prime
        // one number can be divide two number as a * b, so only need to check max i, which i * i < n
        if(n <= 2){
            return 0;
        }
        int[] array = new int[n];
        Arrays.fill(array,1);
        array[0] = 0;
        array[1] = 0;
        for(int i = 2; i*i < n; i++){
            if(array[i] == 1){
                // mark its prime
                 int k = 2;
               while(i*k < n){
                   array[i*k] = 0;
                   k++;
               }
            }
        }
        int ans = 0;
        for(int i: array){
            if(i == 1){
                ans++;
            }
        }
        return ans;
    }
}
