class Solution {
    public int largestUniqueNumber(int[] A) {
        Set<Integer> unique = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int i: A){
            if(!visited.contains(i)){
                visited.add(i);
                unique.add(i);
            }else if(unique.contains(i)){
                unique.remove(i);
            }
        }
        int max = -1;
        for(int i: unique){
            max = Math.max(max,i);
        }
        return max;
    }
}
