class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] leftArray = new int[k+1];
        int[] rightArray = new int[k+1];
        //only need k size array
        for(int i = 1; i <= k; i++){
            leftArray[i] = cardPoints[i-1] + leftArray[i-1];
            rightArray[i] = cardPoints[cardPoints.length -i] + rightArray[i-1];
        }
        int res = 0;
        for(int i = 0; i <= k; i++){
            res = Math.max(res, leftArray[i] + rightArray[k-i]);
        }
        return res ;
    }
}
