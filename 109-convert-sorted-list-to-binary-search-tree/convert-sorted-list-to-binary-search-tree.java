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
    private int n = 0; 

    public TreeNode create(TreeNode root, ListNode head, int i, int j) {
        if (i > j) return null;

        int mid = i + (j - i) / 2;
        ListNode curr = head;
        
        for (int k = 0; k < mid; k++) {
            curr = curr.next;
        }
        
        TreeNode temp = new TreeNode(curr.val);
        
        temp.left = create(temp, head, i, mid - 1);
        temp.right = create(temp, head, mid + 1, j);
        
        return temp;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        return create(null, head, 0, n - 1);
    }
}
