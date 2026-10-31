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
 class pair{
    TreeNode node;
    int level;
    pair(TreeNode node,int level){
        this.level=level;
        this.node=node;
    }
 }
class Solution {
    int max=0;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return 0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        max = root.val;
        int currlevel=0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            if(currlevel!=curr.level){
                max=curr.node.val;
                currlevel = curr.level;
            }
            if(curr.node.left!=null) q.add(new pair(curr.node.left,curr.level+1));
            if(curr.node.right!=null) q.add(new pair(curr.node.right,curr.level+1));
        }
        return max;
    }
}