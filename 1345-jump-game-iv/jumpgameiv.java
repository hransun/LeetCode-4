class Solution {
    public int minJumps(int[] arr) {
         Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int res = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(cur == arr.length-1){
                    return res;
                }
                for(int j : map.get(arr[cur])){
                    if(!visited[j]){
                       queue.offer(j);
                       visited[j] = true;
                    }
                }
                //对已经visited过的数字清0 对应的list，避免重复计算
                //ex: 7,7,7,7,.....7,7,1
                //这里map<7, <0,1,2,....>> 这里对7只要访问map一次即可把7对应的所有index都放到queue里面，后面在读到7就不要操作了
                //这里是对算法的优化，这样就不用再进入for loop查看有没有visited过
                //这里不能用remove 否则for(int j : map.get(arr[cur])) 会npe
                map.get(arr[cur]).clear();
                if(cur-1 >0 && !visited[cur-1]){
                    queue.offer(cur-1);
                    visited[cur-1] = true;
                }
                if(cur+1 < arr.length && !visited[cur+1]){
                    queue.offer(cur+1);
                    visited[cur+1] = true;
                }
            }
            res++;
        }
        return -1;
    }
}
