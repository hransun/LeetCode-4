class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      //bfs
        Map<Integer,List<Integer>> parent = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < ppid.size(); i++){
            if(!parent.containsKey(ppid.get(i))){
                parent.put(ppid.get(i), new ArrayList<>());
            }
            parent.get(ppid.get(i)).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(kill);
        while(!queue.isEmpty()){
           int cur = queue.poll();
           if(res.add(cur) && parent.containsKey(cur)){
               List<Integer> list = parent.get(cur);
               for(int i: list){
                   queue.offer(pid.get(i));
               }
           }
        }
        return res;
    }
}
