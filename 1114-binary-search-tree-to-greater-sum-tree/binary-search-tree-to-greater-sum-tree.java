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
    private int sum=0;
    public void add(TreeNode root){
        if(root==null) return;
        add(root.right);
        root.val+=sum;
        sum=root.val;
        add(root.left);

    }
    public TreeNode bstToGst(TreeNode root) {
        add(root);
        return root;
    }
}