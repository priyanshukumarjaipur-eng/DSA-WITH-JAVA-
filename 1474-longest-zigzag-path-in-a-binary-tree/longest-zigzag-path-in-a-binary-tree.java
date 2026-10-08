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
    private int max=0;
    public void maxzig(TreeNode root,char c,int count){
        if(root==null) return;
        max=Math.max(count,max);
        if(c=='l'){
            maxzig(root.right,'r',count+1);
            maxzig(root.left,'l',1);
        } 
        else{
            maxzig(root.left,'l',count+1);
            maxzig(root.right,'r',1);
            
        }
    }
    public int longestZigZag(TreeNode root) {
        max=0;
        maxzig(root,'l',0);
        maxzig(root,'r',0);
        return max;
    }
}