public class Solution {
    public int findPairs(int[] nums, int k) {
 //only need to return the unique pair, use set
        // case 1: set.contains(i)
        // k == 0 ==> check duplicated set
        // k != 0 ==> already generated the related pair, do nothing
        // case 2: !set.contains(i)
        // check i-k and i+k
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicated = new HashSet<>();
        int count = 0;
        for(int i: nums){
           if(set.contains(i)){
               if(k == 0 && !duplicated.contains(i)){
                   count++;
                   duplicated.add(i);
               }
           }else{
               int t1 = i-k;
               int t2 = i+k;
               if(k != 0 && set.contains(t1)){
                   count++;
               }
               if(k != 0 && set.contains(t2)){
                   count++;
               }
               set.add(i);
           }

        }
        return count;
    }
}
