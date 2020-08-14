class Solution {
    public int hIndex(int[] citations) {
        // find the index i which array[i] >= n-i, return n-i
       Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= n-i){
                return n-i;
            }
        }
        return 0;
    }
}
