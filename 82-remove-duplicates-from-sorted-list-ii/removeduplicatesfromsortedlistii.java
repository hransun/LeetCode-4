/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null || cur.val != next.val){
                prev.next = cur;
                cur = cur.next;
                prev = prev.next;
                continue;
            }
            while(next != null && cur.val == next.val){
                cur = cur.next;
                next = next.next;
            }
            cur = next;
        }
        //post process: prev 之后所有的数字都是repetitive，prev需要手动指向null
        prev.next = null;
        return dummy.next;
    }
}
