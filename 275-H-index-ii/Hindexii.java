class Solution {
    public int hIndex(int[] citations) {
        //find the array[i], that has n- i element that are smaller than array[i]
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int m = left +(right - left) / 2;
            if(citations[m] == n - m ) {
                return n - m;
            }else if(citations[m] > n - m) {
                right = m - 1;
            }else {
                left = m +1;
            }
        }
        return n - left;
    }
}
