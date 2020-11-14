class Solution {
    public int minCostToMoveChips(int[] position) {
        // sum up all the even position and odd position, which cost 0
        // the min  of these sum is the ans
        int odd = 0;
        int even = 0;
        for(int i: position){
            if(i%2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        return Math.min(odd,even);
    }
}
