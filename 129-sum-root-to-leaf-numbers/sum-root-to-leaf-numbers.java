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
    public void sumf(TreeNode root,int csum){
        if(root==null) return;
        csum=csum*10+root.val;
        if(root.left==null && root.right==null){
            sum+=csum;
            return;
        }
        sumf(root.left,csum);
        sumf(root.right,csum);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sum=0;
        sumf(root,0);
        return sum;
    }
}