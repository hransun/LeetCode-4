class Solution {
     public int[] distributeCandies(int candies, int num_people) {
       int[] res = new int[num_people];
        int index = 0;
        int count = 0;
        int length = num_people;
        while(candies > 0){
            index %= length;
            if(candies>=count+1){
                res[index] += count+1;
                candies -= (count+1);
            }else{
                res[index] += candies;
                candies = 0;
            }
            index++;
            count++;
        }
        return res;
    }
}
