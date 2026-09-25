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
    public static void mirror(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right== null) return;
        TreeNode l=root.left;
        TreeNode r=root.right;
        root.left=r;
        root.right=l;
        mirror(root.left);
        mirror(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        mirror(root);
        return root;
    }
}