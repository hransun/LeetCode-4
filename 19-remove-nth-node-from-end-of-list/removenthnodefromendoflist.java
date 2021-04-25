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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //one pass solution
        //the gap between tail and cur is n
        //let tail move to n step, then start to move cur, and tail until tial meet null
        ListNode cur = head;
        ListNode prev = null;
        ListNode tail = head;
        int index = 0;
        while(index < n){
            tail = tail.next;
            index++;
        }
        if(tail == null){
            return head.next;
        }
        while(tail != null){
            tail = tail.next;
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}
