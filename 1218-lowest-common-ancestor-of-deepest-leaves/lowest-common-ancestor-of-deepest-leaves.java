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
        this.node=node;
        this.level=level;
    }
 }
class Solution {
    private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) return null;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        int clevel=0;
        TreeNode maxdept=root;
        while(!q.isEmpty()){
            pair curr=q.remove();
            if(clevel<curr.level){
                clevel=curr.level;
                maxdept=curr.node;
            }
            else if (clevel == curr.level && curr.node != root) {
                maxdept = getLCA(root, maxdept, curr.node);
            }
            if(curr.node.left!=null) q.add(new pair(curr.node.left,curr.level+1));
            if(curr.node.right!=null) q.add(new pair(curr.node.right,curr.level+1));
        }
        return maxdept;
    }
}