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
    public boolean isPalindrome(ListNode head) {
        //revers half listnode and compare
        int length = 0;
        ListNode c1 = head;
        while(c1 != null){
            length++;
            c1 = c1.next;
        }
        int mid = length/2;
        if(length%2 == 1){
            mid++;
        }

        c1 = head;
        int index = 0;
        ListNode prev = null;
        while(index < mid){
            prev = c1;
            c1 = c1.next;
            index++;
        }
        prev.next = null;
        ListNode c2 = reverse(c1);
        c1 = head;
        while(c2 != null){
            if(c1.val != c2.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
