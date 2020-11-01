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
    // travsal the head, and append the node of val in to list of Integer
    // reverse the list
    // calcualte the sum
    // 1011 ==> 1101
    //          i
    // if array[i] == 1 => int cur = Math.pow(2,i)
    // sum += cur
    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur.val);
            cur = cur.next;
        }
        int size = list.size();
        int sum = 0;
        for(int i = 0; i < size; i++){
            if(list.get(i) == 1){
                sum += (int)Math.pow(2.0,(size-i-1)*1.0);
            }
        }
        return sum;
    }
}
