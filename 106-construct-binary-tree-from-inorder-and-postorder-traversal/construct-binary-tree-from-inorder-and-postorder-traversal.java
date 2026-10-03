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
    public static TreeNode create(int post[],int in[], int plo,int phi,int ilo,int ihi){
        int r=0;
        if (plo > phi || ilo > ihi) return null;
        for(int i=ilo;i<=ihi;i++){
            if(in[i]==post[plo]) r=i;
        }
        TreeNode root=new TreeNode(in[r]);
        int lsub=r-ilo;
        int rsub=ihi-r; 
        root.right = create(post, in, plo + 1, plo + rsub, r + 1, ihi); 
        root.left = create(post, in, plo + rsub + 1, phi, ilo, r - 1); 
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=postorder.length;
        int m=inorder.length;
         for (int i = 0; i < n / 2; i++) {
            int temp = postorder[i];
            postorder[i] = postorder[n - 1 - i];
            postorder[n - 1 - i] = temp;
        }
        TreeNode root=create(postorder,inorder,0,n-1,0,m-1);
        return root;
    }
}