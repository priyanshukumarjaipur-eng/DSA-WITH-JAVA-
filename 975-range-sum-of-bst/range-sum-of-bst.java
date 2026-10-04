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
    public void rangeSum(TreeNode root,int low,int high){
        if(root==null) return;
        if(root.val>=low && root.val<=high) sum+=root.val;
          if (root.val > low) {
            rangeSum(root.left, low, high);
        }
        if (root.val < high) {
            rangeSum(root.right, low, high);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        rangeSum(root,low,high);
        return sum;
    }
}