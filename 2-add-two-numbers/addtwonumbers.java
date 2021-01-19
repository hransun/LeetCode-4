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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // l1 = reverse(l1);
        // l2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int car = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val+ car;
            if(sum >= 10){
                sum -= 10;
                car = 1;
            }else{
                car = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + car;
            if(sum >= 10){
                sum -= 10;
                car = 1;
            }else{
                car = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;

        }
        while(l2 != null){
            int sum = l2.val + car;
            if(sum >= 10){
                sum -= 10;
                car = 1;
            }else{
                car = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            l2 = l2.next;
        }
        if(car == 1){
            cur.next = new ListNode(car);
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode head){
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
