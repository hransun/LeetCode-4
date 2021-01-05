class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //T: O(n) S; O(n)
        // map<int[i],i>
        // the order inside of pair must match, however the order of pair can be not
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],i);
        }
        for(int[] cur: pieces){
            int prev = -1;
            for(int i: cur){
                if(!map.containsKey(i) || (prev != -1 && map.get(i) -1 != prev)){
                    return false;
                }
                prev = map.get(i);
            }
        }
        return true;
    }
}
