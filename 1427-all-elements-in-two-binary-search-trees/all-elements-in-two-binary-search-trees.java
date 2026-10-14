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
    public static void add(TreeNode root,List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        add(root.left,ans);
        add(root.right,ans);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans=new ArrayList<>();
        add(root1,ans);
        add(root2,ans);
        Collections.sort(ans);
        return ans;
    }
}