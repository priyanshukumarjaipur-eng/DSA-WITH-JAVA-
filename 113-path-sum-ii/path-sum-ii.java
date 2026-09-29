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
    public static void check(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> x) {
        if(root==null) return;
        x.add(root.val);
        if (root.left == null && root.right == null) {
            if(targetSum - root.val == 0){
                ans.add(new ArrayList(x));
            }
        }
        check(root.left, targetSum - root.val, ans, x); 
        check(root.right, targetSum - root.val, ans, x);
        x.remove(x.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> x=new ArrayList<>();
        if(root==null) return ans;
        check(root,targetSum,ans,x);
        return ans;
    }
}