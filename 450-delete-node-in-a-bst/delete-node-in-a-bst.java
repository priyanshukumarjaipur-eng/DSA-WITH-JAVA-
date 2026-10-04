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
    public TreeNode delete(TreeNode root,int key){
        if(root==null) return null;
        if(root.val==key && root.right==null) return root.left;
        else if(root.val==key && root.left==null) return root.right;
        if(root.val==key && (root.left!=null && root.right!=null)){
            TreeNode curr=root.right;
            while(curr.left!=null) curr=curr.left;
            curr.left=root.left;
            return root.right;
        }
        if(key<root.val){
            root.left=delete(root.left,key);
        }
        else if(key>root.val){
            root.right=delete(root.right,key);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        return delete(root,key);
    }
}