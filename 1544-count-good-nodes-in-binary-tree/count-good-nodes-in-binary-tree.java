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
    private TreeNode prev=null;
    private int good=0;
    public void dfs(TreeNode root,TreeNode prev){
        if(root==null) return;
        if(root.val>=prev.val){
            good++;
            prev=root;
        }
        dfs(root.left,prev);
        dfs(root.right,prev);
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root);
        return good;
    }
}