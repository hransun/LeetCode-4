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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(-1);
        ListNode s = smaller;
        ListNode bigger = new ListNode(-1);
        ListNode b = bigger;
        ListNode cur = head;
        while(cur != null){
            if(cur.val >= x){
                b.next = cur;
                b = b.next;
                cur = cur.next;
                b.next = null;
            }else{
                s.next = cur;
                s = s.next;
                cur = cur.next;
                s.next = null;
            }

        }
        s.next = bigger.next;
        return smaller.next;

    }
}
