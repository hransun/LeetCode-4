class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i: rooms.get(0)){
            queue.offer(i);
            set.add(i);
        }
        while(!queue.isEmpty()){
            int index = queue.poll();
            List<Integer> next = rooms.get(index);
            for(int i: next){
                if(set.add(i)){
                    queue.offer(i);
                }
            }
        }
        for(int i = 0; i< rooms.size(); i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}
