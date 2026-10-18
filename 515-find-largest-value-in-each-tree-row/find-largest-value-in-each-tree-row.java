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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(root,0));
        int max = Integer.MIN_VALUE; 
        int currlevel=0;
        while(!q.isEmpty()){
            pair curr=q.remove();
            if(currlevel!=curr.level){
                ans.add(max);
                currlevel=curr.level;
                 max = Integer.MIN_VALUE;
            }
            max=Math.max(max,curr.node.val);
            if(curr.node.left!=null) q.add(new pair(curr.node.left,curr.level+1));
            if(curr.node.right!=null) q.add(new pair(curr.node.right,curr.level+1));
        }
        ans.add(max); 
        return ans;
    }
}