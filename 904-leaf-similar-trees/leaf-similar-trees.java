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
    public static void find(TreeNode root1,ArrayList<Integer> ans1){
        if(root1==null) return;
        if(root1.left==null && root1.right==null){
            ans1.add(root1.val);
        }
        find(root1.left,ans1);
        find(root1.right,ans1);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        ArrayList<Integer> ans1=new ArrayList<>();
        ArrayList<Integer> ans2=new ArrayList<>();
        find(root1,ans1);
        find(root2,ans2);
       
        return ans1.equals(ans2);
    }
}