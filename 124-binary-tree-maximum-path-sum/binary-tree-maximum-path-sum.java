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
    private int max = Integer.MIN_VALUE; 
    private int calculateDepth(TreeNode root) { 
        if (root == null) return 0;  
        int leftDepth = Math.max(0, calculateDepth(root.left)); 
        int rightDepth = Math.max(0, calculateDepth(root.right));    
        max = Math.max(max, leftDepth + rightDepth + root.val);    
        return root.val + Math.max(leftDepth, rightDepth); 
    } 
    public int maxPathSum(TreeNode root) { 
        if (root == null) return 0; 
        calculateDepth(root);  
        return max; 
    } 
}
