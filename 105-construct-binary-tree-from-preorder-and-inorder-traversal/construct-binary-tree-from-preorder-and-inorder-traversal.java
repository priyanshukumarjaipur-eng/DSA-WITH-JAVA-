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
    public static TreeNode create(int pre[],int in[], int plo,int phi,int ilo,int ihi){
        int r=0;
        if (plo > phi || ilo > ihi) return null;
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==pre[plo]) r=i;
        }
        TreeNode root=new TreeNode(in[r]);
        int lsub=r-ilo;
        int rsub=ihi-r;
        root.left=create(pre,in,plo+1,plo+lsub,ilo,r-1);
        root.right=create(pre,in,plo+lsub+1,phi,r+1,ihi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        int m=inorder.length;
        TreeNode root=create(preorder,inorder,0,n-1,0,m-1);
        return root;
    }
}