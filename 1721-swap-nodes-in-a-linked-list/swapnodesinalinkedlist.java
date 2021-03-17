class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = null;
        ListNode cur = head;
        int index = 1;
        while(cur != null){
            if(index == k){
                first = cur;
            }
            index++;
            cur = cur.next;
        }
        //here index == length+1, so no need to -1 anymore
        int secondIndex = index-k;
        index = 1;
        ListNode second = null;
        cur = head;
        while(cur != null){
            if(index == secondIndex){
                second = cur;
            }
            cur = cur.next;
            index++;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}
