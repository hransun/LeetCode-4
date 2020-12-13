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
    ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        //T: o(n)
        //resovior sampling
        ListNode cur = head;
        int res = -1;
        for(int i = 1; cur != null; i++){
            //if the random index == cur index, update res
            if((int)(Math.random()*i) == i-1){
                res = cur.val;
            }
            cur = cur.next;
        }
        return res;
    }
}
