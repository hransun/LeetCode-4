class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //T: O(n)
        //find the max place it can put
        // for the cur slot, check whether it can put flower or not
        int count = 0;
        int prev = 0;
        for(int i = 0; i < flowerbed.length;i++){
            //can put flower
            if(prev == 0 && flowerbed[i] == 0 && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                count++;
                // here prev should update to 1 manually
                prev = 1;
            //can't put flowers
            }else{
                prev = flowerbed[i];
            }

        }
        return count >=n ? true: false;

    }

}
