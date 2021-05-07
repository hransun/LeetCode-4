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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode midNode = head;
        int lengthMid = getLength(head)/2;
        ListNode prev = null;
        while(lengthMid > 0){
            prev = midNode;
            midNode = midNode.next;
            lengthMid--;
        }
        TreeNode root = new TreeNode(midNode.val);
        ListNode second = midNode.next;
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(second);
        return root;

    }
    private int getLength(ListNode head){
        int length =0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }
}
