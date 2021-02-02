class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Ele> minHeap = new PriorityQueue<>((a, b ) -> (a.val - b.val));
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for(int i = 0; i< lists.length; i++){
            ListNode head = lists[i];
            if(head != null){
                minHeap.offer(new Ele(head.val, head));
            }
        }
        while(!minHeap.isEmpty()){
            Ele node = minHeap.poll();
            ListNode point = node.point;
            int val = node.val;
            cur.next = new ListNode(val);
            cur = cur.next;
            point = point.next;
            if(point != null){
                minHeap.offer(new Ele(point.val, point));
            }
        }
        return dummy.next;
    }
    private static class Ele{
        int val;
        ListNode point;
        Ele(int val, ListNode point){
            this.val = val;
            this.point = point;
        }
    }
}
