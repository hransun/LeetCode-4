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
    //ex: 123+90
    //step 1： 先从高位开始加 1，11，3
    //step2: reverse之后计算carrer 3， 11， 1 =》 3， 1. 2
    //step3: revserse之后返回 =》 2，1，3

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            while(length1 >0 && length1 > length2){
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
                cur = cur.next;
                length1--;
            }
            while(length2 >0 && length2 > length1){
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
                cur = cur.next;
                length2--;
            }
            cur.next = new ListNode(l1.val + l2.val);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode head = reverse(dummy.next);
        cur = head;
        int car = 0;
        ListNode prev = null;
        while(cur != null){
            int sum = cur.val + car;
            if(sum >= 10){
                cur.val = (sum-10);
                car = 1;
            }else{
                cur.val = sum;
                car = 0;
            }
            prev = cur;
            cur = cur.next;

        }
        if(car == 1){
            prev.next = new ListNode(car);
        }
        return reverse(head);
    }
    private int getLength(ListNode head){
        int res = 0;
        while(head != null){
            res++;
            head = head.next;
        }
        return res;
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
