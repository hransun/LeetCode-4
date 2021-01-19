public class Solution {
    public int findPairs(int[] nums, int k) {
 //only need to return the unique pair, use set
        // case 1: set.contains(i)
        // k == 0 ==> check duplicated set
        // case 2: !set.contains(i)
        // check i-k and i+k
        Set<Integer> set = new HashSet<>();
       //just for the case k == 0; check whether the pair has generated before
       Set<Integer> duplicated = new HashSet<>();
       int count = 0;
       for(int i: nums){
           if(k == 0 && !duplicated.contains(i) && set.contains(i)){
               count++;
               duplicated.add(i);
               continue;
           }
           int t1 = i-k;
           int t2 = i+k;
           if(k != 0 && !set.contains(i)){
               //这里需要非开写，因为可能会出现一种情况既能contains t1 也能contains t2
               if(set.contains(t1)){
                   count++;
               }
               if(set.contains(t2)){
                   count++;
               }

           }
           set.add(i);
       }
       return count;
    }
}
