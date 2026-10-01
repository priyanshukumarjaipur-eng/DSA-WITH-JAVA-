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
    // public static void preorder(TreeNode root,List<Integer> ans){
    //     if(root==null) return;
    //     ans.add(root.val);
    //     preorder(root.left,ans);
    //     preorder(root.right,ans);
    // }
    public void flatten(TreeNode root) {
        // List<Integer> ans=new ArrayList<>();
        // preorder(root,ans);
        // TreeNode curr=root;
        // for(int i=1;i<ans.size();i++){
        //     TreeNode temp=new TreeNode(ans.get(i));
        //     curr.right=temp;
        //     curr.left=null;
        //     curr=curr.right;
        // }
        if(root==null) return;
        TreeNode left=root.left;
        TreeNode right=root.right;
        root.left=null;
        root.right=null;
        flatten(left);
        flatten(right);
        root.right=left;
        TreeNode last=root;
        while(last.right!=null) last=last.right;
        last.right=right;
    }
}