class Solution {
    public boolean canReach(int[] arr, int start) {
        //T: O(n) S: O(n)
        List<Integer> target = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                target.add(i);
            }
        }
        for(int end : target){
            if(bfs(arr, start, end)){
                return true;
            }
        }
        return false;
    }
    private boolean bfs(int[] array, int start, int end){
        boolean[] visited = new boolean[array.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i = 0; i < size; i++){
                int integer = queue.poll();
                if(integer == end){
                    return true;
                }
                if(integer + array[integer] < array.length && !visited[integer + array[integer]]){
                    queue.offer(integer+array[integer]);
                    visited[integer + array[integer]] = true;
                }
                if(integer - array[integer] >=0  && !visited[integer - array[integer]]){
                    queue.offer(integer-array[integer]);
                    visited[integer - array[integer]] = true;
                }
            }
        }
        return false;
    }
}
