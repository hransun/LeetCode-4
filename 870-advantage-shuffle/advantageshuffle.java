class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        // A, B min sort, and compare one by one
        // A: X1, X2, X3
        //B:  Y1  Y2  y3
        // if(x1 <= Y1), move pointer to X2, check X2 > Y1? if so, put X2 in the index 0
        // and X1 must can't use, put in the queue, and fill in the whereever empty position
        PriorityQueue<Pair<Integer, Integer>> min = new PriorityQueue<>((a,b)->(int)(a.getKey()) - (int)(b.getKey()));
        for(int i = 0; i < B.length; i++){
            min.add(new Pair(B[i],i));
        }
        Arrays.sort(A);
        int[] res = new int[A.length];
        Arrays.fill(res,-1);
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] > (int)(min.peek().getKey())){
                int index = (int)(min.poll().getValue());
                res[index] = A[i];
            }else{
                queue.offer(A[i]);
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i] == -1){
                res[i] = queue.poll();
            }
        }
        return res;

    }
}
