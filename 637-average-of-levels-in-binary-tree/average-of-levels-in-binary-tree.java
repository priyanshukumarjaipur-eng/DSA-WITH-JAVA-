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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int lsize=q.size();
            double lsum=0;
            for(int i=0;i<lsize;i++){
                TreeNode curr=q.remove();
                lsum+=curr.val;

                if(curr.left !=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            ans.add(lsum/lsize);
        }
        return ans;
    }
}