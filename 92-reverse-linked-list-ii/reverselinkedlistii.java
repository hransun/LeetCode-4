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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = getLocation(dummy, m-1);
        ListNode end = getLocation(dummy, n);
        ListNode start = prev.next;
        ListNode next = end.next;
        reverse(start, end);
        prev.next = end;
        start.next =next;
        return dummy.next;
    }
    private ListNode getLocation(ListNode head, int index){
        ListNode cur = head;
        int i = 0;
        while(i < index){
            cur = cur.next;
            i++;
        }
        return cur;
    }
    private void reverse(ListNode head, ListNode tail){
        ListNode prev = null;
        ListNode cur = head;
        while(prev != tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
