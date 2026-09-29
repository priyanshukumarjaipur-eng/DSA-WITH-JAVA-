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
    private int x=0;
    public void check(TreeNode root,long target){
        if(root==null) return;
        if(target-root.val==0){
            x++;
        }
        check(root.left,target-root.val);
        check(root.right,target-root.val);

    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        check(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return x;
    }
}