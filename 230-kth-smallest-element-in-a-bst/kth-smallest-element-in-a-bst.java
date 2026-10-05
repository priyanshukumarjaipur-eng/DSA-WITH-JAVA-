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
    public static void add(TreeNode root,int k,ArrayList<Integer> sum){
        if(root==null) return;
        sum.add(root.val);
        add(root.left,k,sum);
        add(root.right,k,sum);
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        ArrayList<Integer> sum=new ArrayList<>();
        add(root,k,sum);
        Collections.sort(sum);
        return sum.get(k-1);

    }
}