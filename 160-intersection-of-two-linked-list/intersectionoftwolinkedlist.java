/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //two poointer
        //一个pointer走到底之后，switch到另外一头
        //最终。两个pointer走的距离都是 a+b的length
        //如果最后他们重叠， 两个pointer一定能会在第一个点重逢
        //否则，两个pointer都会指向null
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = p1 == null? headB:p1.next;
            p2 = p2 == null? headA:p2.next;
        }
        return p1;
    }
}
