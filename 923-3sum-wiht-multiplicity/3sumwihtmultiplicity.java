class Solution {
    public int threeSumMulti(int[] arr, int target) {
        //Arrays.sort(arr);
        long res = 0l;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++){
            int t = target - arr[i];
            int k = i+1;
            int p = arr.length-1;
            while(k < p){
                int temp = arr[k] + arr[p];
                if(temp > t){
                    p--;
                }else if(temp < t){
                    k++;
                    // temp == t
                }else if(arr[k] == arr[p]){
                    //for the range k - p, it's all equal numbers
                    res += (p-k+1)*(p-k)/2;
                    break;
                }else{
                    //arr[k] != arr[p], then check how many adjence numbers are equal to the boundary
                    int left = 1;
                    int right = 1;
                    while(k+1 < p && arr[k] == arr[k+1]){
                        k++;
                        left++;
                    }
                    while(p-1 > k && arr[p] == arr[p-1]){
                        p--;
                        right++;
                    }
                    // XXX NUM YY => C1/3 *C1/2 => 2 *3
                    res += left*right;
                    //after out of loop, k & p need to move one step
                    //because they compare with k+1 ,and p-1
                    //so p and k pointer still point to the prev position
                    p--;
                    k++;
                }
            }
        }
        return (int)(res%1000000007);
    }
}
